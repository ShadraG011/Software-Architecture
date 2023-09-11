package org.example.hw4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Scanner;

public class Program {

    /**
     * Разработать контракты и компоненты системы "Покупка онлайн билетов на автобус в час пик".
     * <p>
     * 1.  Предусловия.
     * 2.  Постусловия.
     * 3.  Инвариант.
     * 4.  Определить абстрактные и конкретные классы.
     * 5.  Определить интерфейсы.
     * 6.  Реализовать наследование.
     * 7.  Выявить компоненты.
     * 8.  Разработать Диаграмму компонент использую нотацию UML 2.0. Общая без деталей.
     */
    public static void main(String[] args) {

        Core core = new Core();
        MobileApp mobileApp = new MobileApp(core.getTicketProvider(), core.getCustomerProvider());
        BusStation busStation = new BusStation(core.getTicketProvider());
        Scanner scanner = new Scanner(System.in);


        System.out.print("Введите свой логин: ");
        String login = scanner.nextLine();
        System.out.print("\nВведите свой пароль: ");
        String password = scanner.nextLine();
        System.out.print("\nВведите номер карты: ");
        String cardNo = scanner.nextLine();

        while (!mobileApp.ticketOver()) {

            if (mobileApp.customerAuthorization(login, password, cardNo)) {

                System.out.println("\nСписок билетов:");
                for (Ticket ticket : mobileApp.showTickets()) {
                    System.out.println(ticket);
                }

                System.out.print("Введите номер билета для покупки:");
                mobileApp.buyTicket(Integer.parseInt(scanner.nextLine()));

                System.out.println("\nКлиент успешно купил билет.");

                Collection<Ticket> tickets = mobileApp.showTickets();
                if (busStation.checkTicket(tickets.stream().findFirst().get().getQrcode())) {
                    System.out.println("Клиент успешно прошел в автобус.");
                }
            }
        }
        System.out.println("Все билеты распроданы!");


    }
}


class Core {

    private final CustomerProvider customerProvider;
    private final TicketProvider ticketProvider;
    private final PaymentProvider paymentProvider;
    private final Database database;

    public Core() {
        database = new Database();
        customerProvider = new CustomerProvider(database);
        paymentProvider = new PaymentProvider();
        ticketProvider = new TicketProvider(database, paymentProvider);
    }

    public TicketProvider getTicketProvider() {
        return ticketProvider;
    }

    public CustomerProvider getCustomerProvider() {
        return customerProvider;
    }

}

/**
 * Покупатель
 */
class Customer {

    private String cardNo;
    private String login;
    private String password;

    private static int counter = 1;

    private final int id;

    private Collection<Ticket> tickets = new ArrayList<>();

    {
        id = ++counter;
    }

    public Customer(String cardNo, String login, String password) {
        this.cardNo = cardNo;
        this.login = login;
        this.password = password;
    }

    public Collection<Ticket> getTickets() {
        return tickets;
    }

    public void setTicket(Ticket ticket) {
        this.tickets.add(ticket);
    }

    public int getId() {
        return id;
    }

    public String getCardNo() {
        return cardNo;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}

/**
 * Билет
 */
class Ticket {

    private int id;

    private boolean sold = false;

    private int customerId;

    private Date date;

    private String qrcode;

    public Ticket(int id, Date date, String qrcode) {
        this.id = id;
        this.date = date;
        this.qrcode = qrcode;
    }

    private boolean enable = true;

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public int getId() {
        return id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public Date getDate() {
        return date;
    }

    public String getQrcode() {
        return qrcode;
    }

    public boolean isEnable() {
        return enable;
    }

    public boolean isSold() {
        return sold;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
        sold = true;
    }

    @Override
    public String toString() {
        return "TicketNumber=" + id +
                ", sold=" + sold +
                ", date=" + date;
    }
}


/**
 * База данных
 */
class Database {

    private static int counter;
    private Collection<Ticket> tickets = new ArrayList<>();
    private Collection<Customer> customers = new ArrayList<>();

    public Database() {
        tickets.add(new Ticket(1, new Date(), "qr1"));
        tickets.add(new Ticket(2, new Date(), "qr2"));
        tickets.add(new Ticket(3, new Date(), "qr3"));

        customers.add(new Customer("1112 2221 2331 1123", "login1", "password1"));
        customers.add(new Customer("1212 3221 2931 1923", "login2", "password2"));
        customers.add(new Customer("1512 2621 2371 3523", "login3", "password3"));

    }

    public Collection<Ticket> getTickets() {
        return tickets;
    }

    public Collection<Customer> getCustomers() {
        return customers;
    }

    /**
     * Получить актуальную стоимость билета
     *
     * @return
     */
    public double getTicketAmount() {
        return 45;
    }

    /**
     * Получить идентификатор заявки на покупку билета
     *
     * @return
     */
    public int createTicketOrder(int clientId) {
        return ++counter;
    }

    public Customer getCustomer(String login, String password) {
        for (Customer customer : customers) {
            if (customer.getLogin().equals(login) && customer.getPassword().equals(password))
                return customer;
        }
        return null;
    }

    public Customer getCustomer(int clientId) {
        for (Customer customer : customers) {
            if (customer.getId() == clientId)
                return customer;
        }
        return null;
    }
}

class PaymentProvider {

    public boolean buyTicket(int orderId, String cardNo, double amount) {
        //TODO: Обращение к платежному шлюзу, попытка выполнить списание средств ...
        return true;
    }

}

/**
 * Мобильное приложение
 */
class MobileApp {

    private Customer customer;
    private final TicketProvider ticketProvider;
    private final CustomerProvider customerProvider;


    public MobileApp(TicketProvider ticketProvider, CustomerProvider customerProvider) {
        this.ticketProvider = ticketProvider;
        this.customerProvider = customerProvider;

    }

    public Collection<Ticket> showTickets() {
        return ticketProvider.getTickets();
    }

    public boolean customerAuthorization(String login, String password, String cardNo) {
        customer = customerProvider.getCustomer(login, password);

        //ИНВАРИАНТ
        checkCustomer(customer, cardNo);
        return true;
    }

    public boolean buyTicket(int ticketNumberId) {
        return ticketProvider.checkBuyTicket(customer.getId(), customer.getCardNo(), ticketNumberId);
    }

    /**
     * Метод для осуществления инварианта
     * @param customer
     * @param cardNo
     */
    private void checkCustomer(Customer customer, String cardNo) {
        if (customer == null) {
            throw new CustomerError("Пассажира с таким логином и паролем не найдено!");
        }
        if (!customer.getCardNo().equals(cardNo)) {
            throw new CustomerError("Введеный номер карты пренадлежит другому пассажиру!");
        }
    }

    public boolean ticketOver() {
        for (Ticket ticket : ticketProvider.getTickets()) {
            if (!ticket.isSold())
                return false;
            else
                continue;
        }
        return true;
    }

}

class TicketProvider {

    private final Database database;
    private final PaymentProvider paymentProvider;

    public TicketProvider(Database database, PaymentProvider paymentProvider) {
        this.database = database;
        this.paymentProvider = paymentProvider;
    }

    public Collection<Ticket> getTickets() {
        return database.getTickets();
    }

    public Collection<Ticket> searchTicket(int clientId, Date date) {

        //region ПРЕДУСЛОВИЕ
        if (clientId < 1 || clientId > database.getCustomers().size()) {
            throw new CustomerError("Ошибка ввода ID клиента!");
        }
        //endregion

        //region РАБОТА С ДАННЫМИ
        Collection<Ticket> tickets = new ArrayList<>();
        for (Ticket ticket : database.getTickets()) {
            if (ticket.getCustomerId() == clientId && ticket.getDate().equals(date))
                tickets.add(ticket);
        }
        //endregion

        //region ПОСТУСЛОВИЕ
        if (tickets.size() == 0) {
            throw new TicketError("Билеты данного пассажира не найдены!");
        }
        //endregion

        return tickets;
    }

    public boolean checkBuyTicket(int clientId, String cardNo, int ticketNumberId) {

        //region ПРЕДУСЛОВИЕ
        if (clientId < 1 || clientId > database.getCustomers().size()) {
            throw new CustomerError("Ошибка ввода ID клиента!");
        }
        //endregion

        //region РАБОТА С ДАННЫМИ
        int orderId = database.createTicketOrder(clientId);
        double amount = database.getTicketAmount();
        //endregion

        //region ПОСТУСЛОВИЕ
        buyTicket(database.getCustomer(clientId), ticketNumberId);
        //endregion

        return paymentProvider.buyTicket(orderId, cardNo, amount);

    }

    public boolean checkTicket(String qrcode) {

        for (Ticket ticket : database.getTickets()) {
            if (ticket.getQrcode().equals(qrcode)) {
                ticket.setEnable(false);
                // Save database ...
                return true;
            }
        }
        return false;
    }

    private void buyTicket(Customer customer, int ticketNumberId) {
        for (Ticket ticket : database.getTickets()) {
            if (ticket.getId() == ticketNumberId) {
                ticket.setCustomerId(customer.getId());
                customer.setTicket(ticket);
            }
        }
    }
}

class CustomerProvider {

    private Database database;

    public CustomerProvider(Database database) {
        this.database = database;
    }

    public Customer getCustomer(String login, String password) {
        Customer customer = database.getCustomer(login, password);
        return customer;
    }

}

/**
 * Автобусная станция
 */
class BusStation {

    private final TicketProvider ticketProvider;

    public BusStation(TicketProvider ticketProvider) {
        this.ticketProvider = ticketProvider;
    }

    public boolean checkTicket(String qrCode) {
        return ticketProvider.checkTicket(qrCode);
    }

}

/**
 * Исключение для обработки Customer
 */
class CustomerError extends NullPointerException {
    public CustomerError(String errorMessage) {
        super(errorMessage);
    }
}

/**
 * Исключение для обработки Ticket
 */
class TicketError extends NullPointerException {
    public TicketError(String errorMessage) {
        super(errorMessage);
    }
}




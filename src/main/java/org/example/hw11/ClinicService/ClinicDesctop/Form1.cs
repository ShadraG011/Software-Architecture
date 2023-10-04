using ClinicServiceNamespace;
using System.Diagnostics;
using System.Reflection.Metadata;

namespace ClinicDesctop
{
    public partial class Form1 : Form
    {
        private ClinicClient clinicClient = new ClinicClient("http://localhost:5076/", new HttpClient());
        public Form1()
        {
            InitializeComponent();

        }

        private void updateView()
        {
            ICollection<Client> clients = clinicClient.ClientGetAllAsync().Result;

            listViewClients.Items.Clear();
            foreach (Client client in clients)
            {
                ListViewItem item = new ListViewItem();
                item.Text = client.ClientId.ToString();
                item.SubItems.Add(new ListViewItem.ListViewSubItem()
                {
                    Text = client.SurName
                });
                item.SubItems.Add(new ListViewItem.ListViewSubItem()
                {
                    Text = client.FirstName
                });
                item.SubItems.Add(new ListViewItem.ListViewSubItem()
                {
                    Text = client.Patronymic
                });
                item.SubItems.Add(new ListViewItem.ListViewSubItem()
                {
                    Text = client.Document
                });
                item.SubItems.Add(new ListViewItem.ListViewSubItem()
                {
                    Text = client.Birthday.DateTime.ToShortDateString()
                });
                listViewClients.Items.Add(item);
            }
        }

        private void btnGetAll_Click(object sender, EventArgs e)
        {
            updateView();
        }

        private void buttonAddClient_Click(object sender, EventArgs e)
        {
            panelClient.Visible = true;
        }

        private void buttonConfirm_Click(object sender, EventArgs e)
        {
            int res;
            switch (buttonConfirmPanel.Text)
            {

                case "Добавить":
                    res = clinicClient.ClientCreateAsync(new CreateClientRequest()
                    {
                        Document = textBoxDocument.Text,
                        SurName = textBoxSecondName.Text,
                        FirstName = textBoxName.Text,
                        Patronymic = textBoxPatromic.Text,
                        Birthday = dateTimePickerBirthDay.Value,
                    }).Result;
                    break;
                case "Изменить":
                    res = clinicClient.ClientUpdateAsync(new UpdateClientRequest()
                    {
                        ClientId = (comboBoxClients.SelectedIndex + 1),
                        Document = textBoxDocument.Text,
                        SurName = textBoxSecondName.Text,
                        FirstName = textBoxName.Text,
                        Patronymic = textBoxPatromic.Text,
                        Birthday = dateTimePickerBirthDay.Value,
                    }).Result;
                    break;
            }
            textBoxDocument.Clear();
            textBoxName.Clear();
            textBoxPatromic.Clear();
            textBoxSecondName.Clear();
            panelClient.Visible = false;
            updateView();
        }

        private void buttonChangeClient_Click(object sender, EventArgs e)
        {
            panelClient.Visible = true;
            comboBoxClients.Visible = true;
            labelUpdateClients.Visible = true;
            ICollection<Client> clients = clinicClient.ClientGetAllAsync().Result;
            comboBoxClients.Items.Clear();
            foreach (Client client in clients)
            {
                comboBoxClients.Items.Add(client.FirstName + " " + client.SurName + " " + client.Patronymic);
            }
            buttonConfirmPanel.Text = "Изменить";
        }

        private void buttonDeleteClient_Click(object sender, EventArgs e)
        {
            panelDeleteClient.Visible = true;
            ICollection<Client> clients = clinicClient.ClientGetAllAsync().Result;
            comboBoxDeleteClient.Items.Clear();
            foreach (Client client in clients)
            {
                comboBoxDeleteClient.Items.Add(client.FirstName + " " + client.SurName + " " + client.Patronymic);
            }
        }

        private void buttonConfirmDelete_Click(object sender, EventArgs e)
        {
            int res = clinicClient.ClientDeleteAsync((comboBoxDeleteClient.SelectedIndex + 1)).Result;
            panelDeleteClient.Visible = false;
            updateView();
        }

        private void buttonDeleteCansel_Click(object sender, EventArgs e)
        {
            panelDeleteClient.Visible = false;
        }

        private void buttonConfirmCanseled_Click(object sender, EventArgs e)
        {
            panelClient.Visible = false;
        }
    }

    public partial class Sample
    {
        public int a;
    }
}
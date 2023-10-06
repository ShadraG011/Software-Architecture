using ClinicService.Controllers;
using ClinicService.Models;
using ClinicService.Models.Requests;
using ClinicService.Services;
using Microsoft.AspNetCore.Mvc;
using Moq;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Reflection.Metadata;
using System.Text;
using System.Threading.Tasks;

namespace ClinicServiceTests
{
    public class ClientControllerTests
    {
        private ClientController _clientController;
        private Mock<IClientRepository> _mocClientRepository;

        public ClientControllerTests()
        {
            _mocClientRepository = new Mock<IClientRepository>();
            _clientController = new ClientController(_mocClientRepository.Object);
        }


        public static readonly object[][] CorrectIdClientData = {

            new object[] {1},
            new object[] {2},
            new object[] {3},
            new object[] {4},


        };
        [Theory]
        [MemberData(nameof(CorrectIdClientData))]
        public void DeleteClientTest(int clientId) {

            _mocClientRepository.Setup(repository => repository
            .Delete(It.IsNotNull<int>()))
                .Returns(1)
                .Verifiable();
            var operationResult = _clientController.Delete(clientId);

            Assert.IsType<OkObjectResult>(operationResult.Result);
            Assert.IsAssignableFrom<int>(((OkObjectResult)operationResult.Result).Value);
            _mocClientRepository.Verify(repository =>
                repository.Delete(It.IsNotNull<int>()), Times.AtLeastOnce());

        }


        

        [Theory]
        [MemberData(nameof(CorrectIdClientData))]
        public void GetByIdClientTest(int clientId) {

            Client client = new Client();

            _mocClientRepository.Setup(repository => repository
            .GetById(It.IsNotNull<int>()))
                .Returns(client)
                .Verifiable();

            var operationResult = _clientController.GetById(clientId);

            Assert.IsType<OkObjectResult>(operationResult.Result);
            Assert.IsAssignableFrom<Client>(((OkObjectResult)operationResult.Result).Value);

            _mocClientRepository.Verify(repository =>
                repository.GetById(clientId), Times.AtLeastOnce());
        }

        public static readonly object[][] CorrectUpdateClientData =
        {
            new object[] { new Client() {
            ClientId = 1,
            Document = "Document",
            FirstName = "Test",
            SurName = "Test",
            Patronymic = "Test",
                Birthday = DateTime.Now,

            } },
            new object[] { new Client() {
            ClientId = 2,
            Document = "Document",
            FirstName = "Test1",
            SurName = "Test1",
            Patronymic = "Test1",
                Birthday = DateTime.Now,

            } },
            new object[] { new Client() {
            ClientId = 3,
            Document = "Document",
            FirstName = "Test2",
            SurName = "Test2",
            Patronymic = "Test2",
                Birthday = DateTime.Now,

            } },
        };

        [Theory]
        [MemberData(nameof(CorrectUpdateClientData))]
        public void UpdateClietsTest(Client client)
        {


            _mocClientRepository.Setup(repository => repository.Update(It.IsNotNull<Client>())).Returns(1).Verifiable();

            var operationResult = _clientController.Update(new UpdateClientRequest()
            {
                ClientId = client.ClientId,
                Document = client.Document,
                Birthday = client.Birthday,
                SurName = client.SurName,
                FirstName = client.FirstName,
                Patronymic = client.Patronymic,


            });

            Assert.IsType<OkObjectResult>(operationResult.Result);
            Assert.IsAssignableFrom<int>(((OkObjectResult)operationResult.Result).Value);
            _mocClientRepository.Verify(repository =>
                repository.Update(It.IsNotNull<Client>()), Times.AtLeastOnce());


        }

        [Fact]
        public void GetAllClientsTest()
        {
            // [1.1] Подготовка данных для тестирования

            // [1.2]

            List<Client> list = new List<Client>();
            list.Add(new Client());
            list.Add(new Client());
            list.Add(new Client());


            _mocClientRepository.Setup(repository =>
                repository.GetAll()).Returns(list);

            // [2] Исполнение тестируемого метода
            var operationResult = _clientController.GetAll();

            // [3] Подготовка эталонного результата, проверка результата
            Assert.IsType<OkObjectResult>(operationResult.Result);
            Assert.IsAssignableFrom<List<Client>>(((OkObjectResult)operationResult.Result).Value);

            _mocClientRepository.Verify(repository =>
                repository.GetAll(), Times.AtLeastOnce());
        }



        public static readonly object[][] CorrectCreateClientData =
        {
            new object[] { new DateTime(1985, 5, 20), "123 1234", "Иванов", "Андрей", "Сергеевич" },
            new object[] { new DateTime(1987, 2, 18), "123 2222", "Иванов", "Андрей", "Сергеевич" },
            new object[] { new DateTime(1979, 1, 22), "123 4321", "Иванов", "Андрей", "Сергеевич" },
        };

        [Theory]
        [MemberData(nameof(CorrectCreateClientData))]
        public void CreateClientTest(DateTime birthday, string document, string surName, string firstName, string patronymic)
        {
            _mocClientRepository.Setup(repository =>
            repository
                .Create(It.IsNotNull<Client>()))
                .Returns(1).Verifiable();   

            var operationResult = _clientController.Create(new CreateClientRequest
            {
                Birthday = birthday,
                Document = document,
                SurName = surName,
                FirstName = firstName,
                Patronymic = patronymic
            });

            Assert.IsType<OkObjectResult>(operationResult.Result);
            Assert.IsAssignableFrom<int>(((OkObjectResult)operationResult.Result).Value);
            _mocClientRepository.Verify(repository =>
                repository.Create(It.IsNotNull<Client>()), Times.AtLeastOnce());

        }

    }
}

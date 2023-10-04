namespace ClinicDesctop
{
    partial class Form1
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///  Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            listViewClients = new ListView();
            columnHeaderId = new ColumnHeader();
            columnHeaderSurName = new ColumnHeader();
            columnHeaderFirstName = new ColumnHeader();
            columnHeaderPatronymic = new ColumnHeader();
            columnHeaderDocument = new ColumnHeader();
            columnHeaderBirtday = new ColumnHeader();
            btnGetAll = new Button();
            buttonChangeClient = new Button();
            buttonAddClient = new Button();
            buttonDeleteClient = new Button();
            panelClient = new Panel();
            buttonConfirmCanseled = new Button();
            labelUpdateClients = new Label();
            comboBoxClients = new ComboBox();
            dateTimePickerBirthDay = new DateTimePicker();
            labelBirthDay = new Label();
            buttonConfirmPanel = new Button();
            labelPatromic = new Label();
            labelName = new Label();
            labelSecondname = new Label();
            labelDocument = new Label();
            textBoxPatromic = new TextBox();
            textBoxName = new TextBox();
            textBoxSecondName = new TextBox();
            textBoxDocument = new TextBox();
            panelDeleteClient = new Panel();
            buttonDeleteCansel = new Button();
            labelDeleteClient = new Label();
            comboBoxDeleteClient = new ComboBox();
            buttonConfirmDelete = new Button();
            panelClient.SuspendLayout();
            panelDeleteClient.SuspendLayout();
            SuspendLayout();
            // 
            // listViewClients
            // 
            listViewClients.Columns.AddRange(new ColumnHeader[] { columnHeaderId, columnHeaderSurName, columnHeaderFirstName, columnHeaderPatronymic, columnHeaderDocument, columnHeaderBirtday });
            listViewClients.FullRowSelect = true;
            listViewClients.GridLines = true;
            listViewClients.Location = new Point(12, 12);
            listViewClients.MultiSelect = false;
            listViewClients.Name = "listViewClients";
            listViewClients.Size = new Size(776, 368);
            listViewClients.TabIndex = 1;
            listViewClients.UseCompatibleStateImageBehavior = false;
            listViewClients.View = View.Details;
            // 
            // columnHeaderId
            // 
            columnHeaderId.Text = "#";
            columnHeaderId.Width = 20;
            // 
            // columnHeaderSurName
            // 
            columnHeaderSurName.Text = "Фамилия";
            columnHeaderSurName.Width = 150;
            // 
            // columnHeaderFirstName
            // 
            columnHeaderFirstName.Text = "Имя";
            columnHeaderFirstName.Width = 150;
            // 
            // columnHeaderPatronymic
            // 
            columnHeaderPatronymic.Text = "Отчество";
            columnHeaderPatronymic.Width = 150;
            // 
            // columnHeaderDocument
            // 
            columnHeaderDocument.Text = "Документ";
            columnHeaderDocument.Width = 150;
            // 
            // columnHeaderBirtday
            // 
            columnHeaderBirtday.Text = "Дата рождения";
            columnHeaderBirtday.Width = 150;
            // 
            // btnGetAll
            // 
            btnGetAll.Location = new Point(668, 386);
            btnGetAll.Name = "btnGetAll";
            btnGetAll.Size = new Size(120, 52);
            btnGetAll.TabIndex = 2;
            btnGetAll.Text = "Отобразить всех клиентов";
            btnGetAll.UseVisualStyleBackColor = true;
            btnGetAll.Click += btnGetAll_Click;
            // 
            // buttonChangeClient
            // 
            buttonChangeClient.Location = new Point(416, 386);
            buttonChangeClient.Name = "buttonChangeClient";
            buttonChangeClient.Size = new Size(120, 50);
            buttonChangeClient.TabIndex = 4;
            buttonChangeClient.Text = "Изменить клиента";
            buttonChangeClient.UseVisualStyleBackColor = true;
            buttonChangeClient.Click += buttonChangeClient_Click;
            // 
            // buttonAddClient
            // 
            buttonAddClient.Location = new Point(290, 387);
            buttonAddClient.Name = "buttonAddClient";
            buttonAddClient.Size = new Size(120, 50);
            buttonAddClient.TabIndex = 5;
            buttonAddClient.Text = "Добавить клиента";
            buttonAddClient.UseVisualStyleBackColor = true;
            buttonAddClient.Click += buttonAddClient_Click;
            // 
            // buttonDeleteClient
            // 
            buttonDeleteClient.Location = new Point(542, 387);
            buttonDeleteClient.Name = "buttonDeleteClient";
            buttonDeleteClient.Size = new Size(120, 50);
            buttonDeleteClient.TabIndex = 6;
            buttonDeleteClient.Text = "Удалить клиента";
            buttonDeleteClient.UseVisualStyleBackColor = true;
            buttonDeleteClient.Click += buttonDeleteClient_Click;
            // 
            // panelClient
            // 
            panelClient.Controls.Add(buttonConfirmCanseled);
            panelClient.Controls.Add(labelUpdateClients);
            panelClient.Controls.Add(comboBoxClients);
            panelClient.Controls.Add(dateTimePickerBirthDay);
            panelClient.Controls.Add(labelBirthDay);
            panelClient.Controls.Add(buttonConfirmPanel);
            panelClient.Controls.Add(labelPatromic);
            panelClient.Controls.Add(labelName);
            panelClient.Controls.Add(labelSecondname);
            panelClient.Controls.Add(labelDocument);
            panelClient.Controls.Add(textBoxPatromic);
            panelClient.Controls.Add(textBoxName);
            panelClient.Controls.Add(textBoxSecondName);
            panelClient.Controls.Add(textBoxDocument);
            panelClient.Location = new Point(234, 161);
            panelClient.Name = "panelClient";
            panelClient.Size = new Size(365, 220);
            panelClient.TabIndex = 7;
            panelClient.Visible = false;
            // 
            // buttonConfirmCanseled
            // 
            buttonConfirmCanseled.Location = new Point(203, 180);
            buttonConfirmCanseled.Name = "buttonConfirmCanseled";
            buttonConfirmCanseled.Size = new Size(117, 32);
            buttonConfirmCanseled.TabIndex = 14;
            buttonConfirmCanseled.Text = "Отменить";
            buttonConfirmCanseled.UseVisualStyleBackColor = true;
            buttonConfirmCanseled.Click += buttonConfirmCanseled_Click;
            // 
            // labelUpdateClients
            // 
            labelUpdateClients.AutoSize = true;
            labelUpdateClients.Location = new Point(6, 9);
            labelUpdateClients.Name = "labelUpdateClients";
            labelUpdateClients.Size = new Size(111, 15);
            labelUpdateClients.TabIndex = 13;
            labelUpdateClients.Text = "Выберите клиента:";
            labelUpdateClients.Visible = false;
            // 
            // comboBoxClients
            // 
            comboBoxClients.FormattingEnabled = true;
            comboBoxClients.Location = new Point(168, 6);
            comboBoxClients.Name = "comboBoxClients";
            comboBoxClients.Size = new Size(194, 23);
            comboBoxClients.TabIndex = 12;
            comboBoxClients.Visible = false;
            // 
            // dateTimePickerBirthDay
            // 
            dateTimePickerBirthDay.Location = new Point(168, 151);
            dateTimePickerBirthDay.Name = "dateTimePickerBirthDay";
            dateTimePickerBirthDay.Size = new Size(194, 23);
            dateTimePickerBirthDay.TabIndex = 11;
            // 
            // labelBirthDay
            // 
            labelBirthDay.AutoSize = true;
            labelBirthDay.Location = new Point(6, 151);
            labelBirthDay.Name = "labelBirthDay";
            labelBirthDay.Size = new Size(140, 15);
            labelBirthDay.TabIndex = 10;
            labelBirthDay.Text = "Введите дату рождения: ";
            // 
            // buttonConfirmPanel
            // 
            buttonConfirmPanel.Location = new Point(45, 180);
            buttonConfirmPanel.Name = "buttonConfirmPanel";
            buttonConfirmPanel.Size = new Size(117, 32);
            buttonConfirmPanel.TabIndex = 8;
            buttonConfirmPanel.Text = "Добавить";
            buttonConfirmPanel.UseVisualStyleBackColor = true;
            buttonConfirmPanel.Click += buttonConfirm_Click;
            // 
            // labelPatromic
            // 
            labelPatromic.AutoSize = true;
            labelPatromic.Location = new Point(6, 125);
            labelPatromic.Name = "labelPatromic";
            labelPatromic.Size = new Size(108, 15);
            labelPatromic.TabIndex = 7;
            labelPatromic.Text = "Введите отчество: ";
            // 
            // labelName
            // 
            labelName.AutoSize = true;
            labelName.Location = new Point(6, 67);
            labelName.Name = "labelName";
            labelName.Size = new Size(81, 15);
            labelName.TabIndex = 6;
            labelName.Text = "Введите имя: ";
            // 
            // labelSecondname
            // 
            labelSecondname.AutoSize = true;
            labelSecondname.Location = new Point(6, 96);
            labelSecondname.Name = "labelSecondname";
            labelSecondname.Size = new Size(111, 15);
            labelSecondname.TabIndex = 5;
            labelSecondname.Text = "Введите фамилию:";
            // 
            // labelDocument
            // 
            labelDocument.AutoSize = true;
            labelDocument.Location = new Point(6, 38);
            labelDocument.Name = "labelDocument";
            labelDocument.Size = new Size(156, 15);
            labelDocument.TabIndex = 4;
            labelDocument.Text = "Введите номер документа: ";
            // 
            // textBoxPatromic
            // 
            textBoxPatromic.Location = new Point(168, 122);
            textBoxPatromic.Name = "textBoxPatromic";
            textBoxPatromic.Size = new Size(194, 23);
            textBoxPatromic.TabIndex = 3;
            // 
            // textBoxName
            // 
            textBoxName.Location = new Point(168, 64);
            textBoxName.Name = "textBoxName";
            textBoxName.Size = new Size(194, 23);
            textBoxName.TabIndex = 2;
            // 
            // textBoxSecondName
            // 
            textBoxSecondName.Location = new Point(168, 93);
            textBoxSecondName.Name = "textBoxSecondName";
            textBoxSecondName.Size = new Size(194, 23);
            textBoxSecondName.TabIndex = 1;
            // 
            // textBoxDocument
            // 
            textBoxDocument.Location = new Point(168, 35);
            textBoxDocument.Name = "textBoxDocument";
            textBoxDocument.Size = new Size(194, 23);
            textBoxDocument.TabIndex = 0;
            // 
            // panelDeleteClient
            // 
            panelDeleteClient.Controls.Add(buttonDeleteCansel);
            panelDeleteClient.Controls.Add(labelDeleteClient);
            panelDeleteClient.Controls.Add(comboBoxDeleteClient);
            panelDeleteClient.Controls.Add(buttonConfirmDelete);
            panelDeleteClient.Location = new Point(234, 12);
            panelDeleteClient.Name = "panelDeleteClient";
            panelDeleteClient.Size = new Size(362, 71);
            panelDeleteClient.TabIndex = 8;
            panelDeleteClient.Visible = false;
            // 
            // buttonDeleteCansel
            // 
            buttonDeleteCansel.Location = new Point(187, 40);
            buttonDeleteCansel.Name = "buttonDeleteCansel";
            buttonDeleteCansel.Size = new Size(162, 23);
            buttonDeleteCansel.TabIndex = 3;
            buttonDeleteCansel.Text = "Отменить";
            buttonDeleteCansel.UseVisualStyleBackColor = true;
            buttonDeleteCansel.Click += buttonDeleteCansel_Click;
            // 
            // labelDeleteClient
            // 
            labelDeleteClient.AutoSize = true;
            labelDeleteClient.Location = new Point(3, 14);
            labelDeleteClient.Name = "labelDeleteClient";
            labelDeleteClient.Size = new Size(111, 15);
            labelDeleteClient.TabIndex = 2;
            labelDeleteClient.Text = "Выберите клиента:";
            // 
            // comboBoxDeleteClient
            // 
            comboBoxDeleteClient.FormattingEnabled = true;
            comboBoxDeleteClient.Location = new Point(143, 11);
            comboBoxDeleteClient.Name = "comboBoxDeleteClient";
            comboBoxDeleteClient.Size = new Size(206, 23);
            comboBoxDeleteClient.TabIndex = 1;
            // 
            // buttonConfirmDelete
            // 
            buttonConfirmDelete.Location = new Point(14, 40);
            buttonConfirmDelete.Name = "buttonConfirmDelete";
            buttonConfirmDelete.Size = new Size(162, 23);
            buttonConfirmDelete.TabIndex = 0;
            buttonConfirmDelete.Text = "Удалить";
            buttonConfirmDelete.UseVisualStyleBackColor = true;
            buttonConfirmDelete.Click += buttonConfirmDelete_Click;
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(800, 450);
            Controls.Add(panelClient);
            Controls.Add(panelDeleteClient);
            Controls.Add(buttonDeleteClient);
            Controls.Add(buttonAddClient);
            Controls.Add(buttonChangeClient);
            Controls.Add(btnGetAll);
            Controls.Add(listViewClients);
            Name = "Form1";
            StartPosition = FormStartPosition.CenterScreen;
            Text = "Моя клиника";
            panelClient.ResumeLayout(false);
            panelClient.PerformLayout();
            panelDeleteClient.ResumeLayout(false);
            panelDeleteClient.PerformLayout();
            ResumeLayout(false);
        }

        #endregion

        private ListView listViewClients;
        private Button btnGetAll;
        private ColumnHeader columnHeaderId;
        private ColumnHeader columnHeaderSurName;
        private ColumnHeader columnHeaderFirstName;
        private ColumnHeader columnHeaderPatronymic;
        private ColumnHeader columnHeaderDocument;
        private Button buttonChangeClient;
        private Button buttonAddClient;
        private Button buttonDeleteClient;
        private Panel panelClient;
        private TextBox textBoxDocument;
        private Label labelPatromic;
        private Label labelName;
        private Label labelSecondname;
        private Label labelDocument;
        private TextBox textBoxPatromic;
        private TextBox textBoxName;
        private TextBox textBoxSecondName;
        private Button buttonConfirmPanel;
        private Label labelBirthDay;
        private DateTimePicker dateTimePickerBirthDay;
        private ColumnHeader columnHeaderBirtday;
        private Label labelUpdateClients;
        private ComboBox comboBoxClients;
        private Panel panelDeleteClient;
        private Label labelDeleteClient;
        private ComboBox comboBoxDeleteClient;
        private Button buttonConfirmDelete;
        private Button buttonConfirmCanseled;
        private Button buttonDeleteCansel;
    }
}
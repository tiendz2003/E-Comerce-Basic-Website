<%@ Page Title="Liên Hệ" Language="C#" MasterPageFile="~/MasterPage/Page.Master" AutoEventWireup="true" CodeBehind="Contact.aspx.cs" Inherits="BTL_Food.BtlWeb.Contact" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
     <meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="../styles/Contact.css" rel="stylesheet" />
</asp:Content>

<asp:Content ID="Content2" ContentPlaceHolderID="content" runat="server">
    <div class="contact-container">
        <h1>Liên Hệ Với Chúng Tôi</h1>
        
            <div class="form-group">
                <label for="txtName">Họ và Tên:</label>
                <asp:TextBox ID="txtName" runat="server" CssClass="form-input" />
            </div>
            <div class="form-group">
                <label for="txtEmail">Địa chỉ Email:</label>
                <asp:TextBox ID="txtEmail" runat="server" CssClass="form-input" />
            </div>
            <div class="form-group">
                <label for="txtPhone">Số Điện Thoại:</label>
                <asp:TextBox ID="txtPhone" runat="server" CssClass="form-input" />
            </div>
            <div class="form-group">
                <label for="txtMessage">Tin Nhắn:</label>
                <asp:TextBox ID="txtMessage" runat="server" TextMode="MultiLine" CssClass="form-input" Rows="5" />
            </div>
            <asp:Button ID="btnSubmit" runat="server" Text="Gửi" CssClass="btnSubmit" OnClick="btnSubmit_Click" />
            <asp:Label ID="lblMessage" runat="server" ForeColor="Green" Visible="False" CssClass="message-label"></asp:Label>

    </div>
</asp:Content>
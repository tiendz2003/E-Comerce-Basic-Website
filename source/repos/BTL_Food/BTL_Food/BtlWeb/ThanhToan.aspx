<%@ Page Title="Thanh toán đơn hàng" Language="C#" MasterPageFile="~/MasterPage/Page.Master" AutoEventWireup="true" CodeBehind="ThanhToan.aspx.cs" Inherits="BTL_Food.ThanhToan" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
    <title>Thanh Toán</title>
    <link href="../styles/ThanhToan.css?v=2.0" rel="stylesheet" />
   
</asp:Content>

<asp:Content ID="Content2" ContentPlaceHolderID="content" runat="server">
    <div class="checkout-container">
        <h2>Thanh Toán</h2>
        <asp:Label ID="lblTotal" runat="server" Text="Tổng cộng: " CssClass="form-input"></asp:Label>
        <div class="form-group">
            <asp:Label ID="lblName" runat="server" Text="Họ và tên:" CssClass="form-input"></asp:Label>
            <asp:TextBox ID="txtName" runat="server" CssClass="form-input" />
        </div>
        <div class="form-group">
            <asp:Label ID="lblAddress" runat="server" Text="Địa chỉ giao hàng:" CssClass="form-input"></asp:Label>
            <asp:TextBox ID="txtAddress" runat="server" CssClass="form-input" />
        </div>
        <div class="form-group">
            <asp:Label ID="lblPhone" runat="server" Text="Số điện thoại:" CssClass="form-input"></asp:Label>
            <asp:TextBox ID="txtPhone" runat="server" CssClass="form-input" />
        </div>
        <asp:Button ID="btnConfirm" runat="server" Text="Xác Nhận Thanh Toán" OnClick="btnConfirm_Click" CssClass="btn-submit" />
    </div>
</asp:Content>

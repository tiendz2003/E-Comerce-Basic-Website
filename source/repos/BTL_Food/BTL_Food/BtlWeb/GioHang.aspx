<%@ Page Title="Giỏ hàng" Language="C#" MasterPageFile="~/MasterPage/Page.Master" EnableEventValidation="false" AutoEventWireup="true" CodeBehind="GioHang.aspx.cs" Inherits="BTL_Food.BtlWeb.GioHang" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
    <link rel="stylesheet" href="../styles/GioHang.css?v=2" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">

</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="content" runat="server">


    <asp:Repeater ID="repeaterCart" runat="server">
        <HeaderTemplate>
            <table>
                <thead>
                    <tr>
                        <th>Tên sản phẩm: </th>
                        <th>Số Lượng</th>
                        <th>Giá</th>
                        <th>Tổng</th>
                        <th>Hành Động</th>
                    </tr>
                </thead>
                <tbody>
        </HeaderTemplate>

        <ItemTemplate>
            <tr>
                <td><%# Eval("food.name") %></td>
                <td><%# Eval("Quantity") %></td>
                <td><%# Eval("food.productPrice", "{0:N0}") %> VND</td>
                <td><%# Eval("totalPrice", "{0:N0}") %> VND</td>
                <td>
                    <asp:Button ID="btnXoa" CommandArgument='<%# Eval("FoodId") %>' runat="server"
                        Text="Xóa" OnClick="btnXoa_Click" />
                </td>
            </tr>
        </ItemTemplate>

        <FooterTemplate>
            </tbody>
        </table>
      
        </FooterTemplate>
    </asp:Repeater>
    <div class="cart-summary">
        <h3>Tổng Giá Trị:</h3>
        <asp:Label ID="lblTotalValue" runat="server" Text="0 VND" />
    </div>



</asp:Content>

<%@ Page Title="Trang chủ" Language="C#" MasterPageFile="~/MasterPage/Page.Master" AutoEventWireup="true" CodeBehind="Home.aspx.cs" Inherits="BTL_Food.Home" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../styles/Home.css"/>
    <title>Danh Mục Sản Phẩm</title>

</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="content" runat="server">
    <main class="main-wrapper">

        <div class="container" id="trangchu">
            <div class="home-title-block" id="home-title">
                <h2 class="home-title">Mọi thứ bạn cần đang trên sàn giao dịch của chúng tôi</h2>
            </div>

            <div class="home-an" id="home-an">
                <% List<BTL_Food.data.Product> food = Application.Get("Product") as List<BTL_Food.data.Product>; %>
                <% if (food != null && food.Count > 0)
                    { %>
                <% foreach (BTL_Food.data.Product c in food)
                    {
                %>
                <div class="col-food">
                    <article class="card-food">
                        <div class="card-header">
                            <a href="Details.aspx?id=<%= c.id %>" title="Xem chi tiết sản phẩm <%= c.name %>">
                                <img class="card-image" src="../img/<%= c.imageUrl %>" title="<%= c.name %>" alt="<%= c.name %>" />
                            </a>
                        </div>
                        <div class="food-info">
                            <div class="card-content">
                                <div class="card-title">
                                    <a href="Details.aspx?id=<%= c.id %>" title="Xem chi tiết sản phẩm <%= c.name %>" class="card-title-link">
                                        <%= c.name %>
                                    </a>
                                </div>
                                <div class="card-price">
                                    Giá: <%= c.productPrice.ToString("N0") + " VND" %>
                                </div>
                            </div>
                        </div>
                    </article>
                </div>
                <% 
                    }%>
                <% }%>
            </div>
        </div>
    </main>
</asp:Content>

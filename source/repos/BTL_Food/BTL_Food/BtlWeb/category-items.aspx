<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPage/Page.Master" AutoEventWireup="true" CodeBehind="category-items.aspx.cs" Inherits="BTL_Food.BtlWeb.WebForm1" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
    <title><%=Request.QueryString["category"] %>  </title>
    <link rel="stylesheet" href="../styles/Home.css" />
    <meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="content" runat="server">
    <main class="main-wrapper">


    <div class="home-an" id="home-an">
        <% //du tinh lam danh muc hien thi cac san pham
            List<BTL_Food.data.Product> food = Application.Get("Product") as List<BTL_Food.data.Product>; %>
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
         
</main>
</asp:Content>

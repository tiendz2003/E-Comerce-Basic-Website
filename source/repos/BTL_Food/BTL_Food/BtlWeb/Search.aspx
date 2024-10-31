<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPage/Page.Master" AutoEventWireup="true" CodeBehind="Search.aspx.cs" Inherits="BTL_Food.BtlWeb.Search" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../styles/Home.css?v=2.0">
    <title>Danh Mục Món Ăn</title>
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="content" runat="server">
    <main class="main-wrapper">
        <div class="container" id="trangtimkiem">
            <div class="timkiem">
                <% List<BTL_Food.data.Product> categories = Application.Get("Product") as List<BTL_Food.data.Product>; %>
                <% string t = Session["Search"] as string ?? string.Empty;%>
                <%foreach (BTL_Food.data.Product c in categories)
                    {%>
                <% if (c.name.IndexOf(t, StringComparison.OrdinalIgnoreCase) >= 0)
                    {%>
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

                <%  } %>



                <% } %>
            </div>

        </div>

    </main>
</asp:Content>

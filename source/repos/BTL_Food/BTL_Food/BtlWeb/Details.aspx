<%@ Page Title="Chi tiết sản phẩm" Language="C#" MasterPageFile="~/MasterPage/Page.Master" AutoEventWireup="true" CodeBehind="Details.aspx.cs" Inherits="BTL_Food.Details" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link  href="../styles/Details.css?v=2.0" rel="stylesheet"/>
</asp:Content>

<asp:Content ID="Content2" ContentPlaceHolderID="content" runat="server">
    <div class="food-detail-container">
        <% 
            // Lấy ID từ URL
            if (int.TryParse(Request.QueryString["id"], out int productId))
            {
     
                List<BTL_Food.data.Product> product = Application.Get("Product") as List<BTL_Food.data.Product>;

            
                var selectedProduct = product?.FirstOrDefault(c => c.id == productId);


                if (selectedProduct != null)
                {
        %>
        <div class="food-detail" id="trangchitietmonan">
            <div class="sidebar-1">
                <div class="img-detail" id="chitietmonan">
                    <img class="anh" src="../img/<%= selectedProduct.imageUrl %>" title="<%= selectedProduct.name %>" alt="Product Image" />
                </div>
            </div>
            <div class="sidebar-2">
                <div class="name-detail">
                    <h6><%= selectedProduct.name %></h6>
                </div>
                <div class="mota-detail">
                    <p><%= selectedProduct.mota %></p>
                </div>
                <div class="price-detail">
                    <p><%= selectedProduct.productPrice.ToString("N0") %> VND</p>
                </div>
                <div class="soluong-detail">
                    <button type="button" id="btn-decrease" class="quantity-btn" onclick="decreaseQuantity()">-</button>
                    <input type="text" id="quantity" value="1" />

                    <button type="button" id="btn-increase" class="quantity-btn" onclick="increaseQuantity()">+</button>
                </div>
                <asp:HiddenField ID="hfFoodId" runat="server" Value="<%= selectedFood.id %>" />
                <asp:HiddenField ID="hfQuantity" runat="server" Value="1" />
                <div class="themgiohang">
                    <asp:Button ID="btnAddToCart" runat="server" CssClass="btnAdd" Text="Thêm vào giỏ hàng" OnClick="btnAddToCart_Click" />
                    <asp:Label ID="lblMessage" runat="server" ForeColor="Green" Visible="False"></asp:Label>
                    
                </div>
            </div>
        </div>
        <% 
            }
            else
            {
        %>
        <p>Sản phẩm không tồn tại.</p>
        <% 
                }
            }
            else
            {
        %>
        <p>ID sản phẩm không hợp lệ.</p>
        <% 
            }
        %>
    </div>

    <script src="../script/?v=2.0"></script>

    <script type="text/javascript">
        function increaseQuantity() {
            var qtyInput = document.getElementById('quantity');
            var hiddenQty = document.getElementById('<%= hfQuantity.ClientID %>');
            qtyInput.value = parseInt(qtyInput.value) + 1;
            hiddenQty.value = qtyInput.value;
        }

        function decreaseQuantity() {
            var qtyInput = document.getElementById('quantity');
            var hiddenQty = document.getElementById('<%= hfQuantity.ClientID %>');

            if (parseInt(qtyInput.value) > 1) {
                qtyInput.value = parseInt(qtyInput.value) - 1;
                hiddenQty.value = qtyInput.value;
            }
        }
    </script>
</asp:Content>

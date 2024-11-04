<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPage/Admin.Master" AutoEventWireup="true" CodeBehind="QLMH.aspx.cs" Inherits="BTL_Food.BtlWeb.QLMH" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
    <link rel="stylesheet" href="../styles/QL.css" />
    <title>Quản lý mặt hàng</title>
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server" >

        <div class="QL">
            <center>QUẢN LÝ MẶT HÀNG</center>
            <center >  
                <div class="input"> <label for="TenMH" >Tên mặt hàng: </label> <input type="text" name="TenMH" id="TenMH"/></div>  
                <div class="input"> <label for="SL">Số Lượng: </label> <input type="number" name="SL"  id="SL" /></div>  
                 <div class="input"> <label for="Price">Giá: </label> <input type="number" name="Price"  id="Price" /></div> 
                <div class="input"> <label for="mota" >Mô tả: </label> <input type="text" name="mota" id="mota"/></div>  
                <div class="input"><label for="file">Ảnh:  </label>  <asp:FileUpload ID="FileUpload" runat="server" CssClass="file" /> </div>  
                
                <input type="submit" id="btAdd" value="Thêm" />
            </center>
     
         
        </div>
        <div class="item-list">
        <%List<BTL_Food.data.Product> product_list = Application[global_asax.PRODUCT] as List<BTL_Food.data.Product>;
            int removeID = Convert.ToInt32("0"+Request.QueryString["removeId"]);

            if (removeID > 0)
            {
                product_list.RemoveAt(removeID - 1);
            }
            foreach (BTL_Food.data.Product i in product_list)
            {


            %>

            <div class="item">
                <div class="image-container">      
                    <img src="../img/<%=i.imageUrl %>" alt=""/>

                </div>
      
                <div class="item-info">
                         <p>Tên SP: <%=i.name %> </p>
                         <br />
                         <p>ID: <%=i.id %></p>
                </div>
                <span class="price">Giá: <%=i.productPrice %> Đ</span>
                <div class="del">  <a role="button" href="QLMH.aspx?removeId=<%=i.id %>" name="btXoa" id="btXoa" >Xóa</a></div>
          
            </div>


        <%            } %>
        </div>
</asp:Content>

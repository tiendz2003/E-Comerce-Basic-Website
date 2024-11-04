<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPage/Admin.Master" AutoEventWireup="true" CodeBehind="QLTK.aspx.cs" Inherits="BTL_Food.BtlWeb.QLTK" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
    <link rel="stylesheet" href="../styles/QL.css"/>
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
      <div class="QL">
      <center>QUẢN LÝ TÀI KHOẢN </center>
      <center >  
          <div class="input"> <label for="email" >Email: </label> <input type="email" name="email" id="email"/></div>  
          <div class="input"> <label for="acc-name">Tên tài khoản: </label> <input type="number" name="acc-name"  id="acc-name" /></div>  
           <div class="input"> <label for="pass">Mật khẩu: </label> <input type="text" name="pass"  id="pass" /></div> 
          
          <input type="submit" id="btAdd" value="Thêm" />
      </center>
     
   
        </div>

  <%List<BTL_Food.data.User> user_list = Application[global_asax.USER] as List<BTL_Food.data.User>;
      string removeID = Request.QueryString["removeId"];

      if (!string.IsNullOrEmpty(removeID) )
      {
          user_list.Remove(user_list.Find(
              p => p.email.Equals(removeID)
              ));
      }
      foreach (BTL_Food.data.User i in user_list)
      {


      %>

      <table >
          <tr>
              <th>Email</th>
              <th>Tên tài khoản</th>
              <th>Mật khẩu</th>
              <th>Chức năng</th>
          </tr>
          <tr>
              <td><%=i.email %></td>
               <td><%=i.nameAccount %></td>
               <td><%=i.password %></td>
                <th > <a role="button" href="QLTK.aspx?removeId=<%=i.email %>" name="btXoa" id="btXoa" >Xóa</a></th>
          </tr>
      </table>


  <%            } %>

</asp:Content>

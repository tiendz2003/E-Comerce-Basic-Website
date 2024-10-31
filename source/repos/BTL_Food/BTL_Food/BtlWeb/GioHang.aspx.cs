using BTL_Food.data;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography.X509Certificates;
using System.Web;
using System.Web.Services;
using System.Web.UI;
using System.Web.UI.WebControls;


namespace BTL_Food.BtlWeb
{
    public partial class GioHang : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)//khoong phai method post
            {

                BindCart();
            }
            
        }

        private void BindCart()
        {
            // Assuming you have a method to get cart items
            var cart = Session["Cart"] as Cart;
            var foodList = Application["Product"] as List<Product>;
            var cartItems = cart.GetItems();// Replace with your data retrieval logic
      
            
     
            double totalValue = cartItems.Sum(item => item.TotalPrice);
         
            lblTotalValue.Text = totalValue.ToString();
            repeaterCart.DataSource = cartItems;
            repeaterCart.DataBind();
        }

        protected void btnXoa_Click(object sender, EventArgs e)
        {
            Button btn = (Button)sender;
            int foodId = Convert.ToInt32(btn.CommandArgument);
            var cart = Session["Cart"] as Cart;
            cart.RemoveItem(foodId);
            BindCart();

        }

    }
}
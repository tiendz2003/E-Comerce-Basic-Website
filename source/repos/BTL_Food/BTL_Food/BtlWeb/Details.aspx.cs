using BTL_Food.data;
using BTL_Food.MasterPage;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace BTL_Food
{
    public partial class Details : System.Web.UI.Page
    {

        protected void Page_Load(object sender, EventArgs e)
        {
            string id = Request.QueryString["id"];
            hfFoodId.Value = id;
            if (!IsPostBack)
            {
                if (ViewState["CartMessage"] != null)
                {
                    lblMessage.Text = ViewState["CartMessage"].ToString();
                    lblMessage.Visible = true; // Hiển thị message
                    ViewState["CartMessage"] = null; // Xóa message sau khi hiển thị
                }

            }
        }

        protected void btnAddToCart_Click(object sender, EventArgs e)
        {
            // Lấy ID món ăn từ HiddenField
            int foodId = int.Parse(hfFoodId.Value);

            // Lấy số lượng từ TextBox
            int quantity = int.Parse(hfQuantity.Value);

            // Khởi tạo giỏ hàng nếu chưa tồn tại
            Cart cart = Session["Cart"] as Cart;
            if (cart == null)
            {
                cart = new Cart();
                Session["Cart"] = cart;
            }
            var listFood = Application["Product"] as List<Product>;
            // Thêm món ăn vào giỏ hàng

            var food = listFood.FirstOrDefault(f => f.id == foodId);


            cart.AddItem(new CartItem(foodId, quantity, food));
            ViewState["CartMessage"] = "Thêm vào giỏ hàng thành công";
        }
    }
}
using BTL_Food.data;
using BTL_Food.MasterPage;
using System;
using System.Collections.Generic;
using System.Runtime.Remoting.Messaging;
using System.Web;


namespace BTL_Food
{
    public class Global : HttpApplication
    {
        public const string USER = "DSUser";
        public const string PRODUCT = "Product";

        protected void Application_Start(object sender, EventArgs e)
        {
            Application[USER] = createUser();
            List<Product> product = new List<Product>
            {

                    new Product() { id = 1, name = "Áo T-Shirt", imageUrl = "ao-nam.jpg", productPrice = 35000, mota = "Áo T-Shirt nam thời trang, chất liệu thoáng mát, phù hợp cho hoạt động hàng ngày và dễ dàng phối đồ." },
                    new Product() { id = 2, name = "Máy Ảnh", imageUrl = "may-anh.jpg", productPrice = 25000, mota = "Máy ảnh chất lượng cao với khả năng chụp ảnh sắc nét và quay video HD, phù hợp cho người yêu nhiếp ảnh." },
                    new Product() { id = 3, name = "Tivi Sony", imageUrl = "thiet-bi-dien-tu.jpg", productPrice = 30000, mota = "Tivi Sony độ phân giải cao, chất lượng hình ảnh sắc nét, mang lại trải nghiệm giải trí tuyệt vời cho gia đình." },
                    new Product() { id = 4, name = "Máy giặt", imageUrl = "thiet-bi-gia-dung.jpg", productPrice = 20000, mota = "Máy giặt tiện lợi với nhiều chế độ giặt, giúp tiết kiệm thời gian và công sức trong công việc gia đình." },
                    new Product() { id = 5, name = "Điện thoại", imageUrl = "dien-thoai.jpg", productPrice = 40000, mota = "Điện thoại thông minh với hiệu năng mạnh mẽ và camera sắc nét, đáp ứng nhu cầu công việc và giải trí." },
                    new Product() { id = 6, name = "Áo nữ", imageUrl = "ao-nu.jpg", productPrice = 60000, mota = "Áo nữ thời trang, phong cách thanh lịch, chất liệu thoải mái, thích hợp cho nhiều dịp khác nhau." },
                    new Product() { id = 7, name = "Aó đấu Man Utd", imageUrl = "manutd.jpg", productPrice = 55000, mota = "Áo đấu chính thức của Manchester United, dành cho fan hâm mộ đội bóng, chất liệu thoáng mát, dễ chịu khi mặc." },
                    new Product() { id = 8, name = "Truyện tranh Conan", imageUrl = "conan.jpg", productPrice = 50000, mota = "Bộ truyện tranh Conan nổi tiếng với các vụ án hấp dẫn và lối dẫn chuyện kịch tính." },
                    new Product() { id = 9, name = "Truyện tranh Đô rê mon", imageUrl = "doremon.jpg", productPrice = 30000, mota = "Truyện tranh Đô rê mon với những cuộc phiêu lưu vui nhộn và ý nghĩa dành cho thiếu nhi." },
                    new Product() { id = 10, name = "Truyện tranh Naruto", imageUrl = "naruto.jpg", productPrice = 25000, mota = "Bộ truyện tranh Naruto với các câu chuyện về tình bạn và nghị lực, đầy cảm hứng cho người đọc." },
                    new Product() { id = 11, name = "Ví nữ", imageUrl = "tuivinu.jpg", productPrice = 35000, mota = "Ví nữ thanh lịch, thiết kế nhỏ gọn, tiện dụng và dễ dàng mang theo, phù hợp với phong cách hiện đại." },
                    new Product() { id = 12, name = "Laptop Dell Inspiron 3000", imageUrl = "laptop.jpg", productPrice = 45000, mota = "Laptop Dell Inspiron 3000 hiệu năng ổn định, phù hợp cho công việc và học tập, thiết kế nhỏ gọn, dễ mang theo." },
                    new Product() { id = 13, name = "Xe máy Wave", imageUrl = "xemay.jpg", productPrice = 35000, mota = "Xe máy Wave tiết kiệm xăng, bền bỉ, phù hợp cho việc di chuyển hàng ngày." },
                    new Product() { id = 14, name = "Nước hoa", imageUrl = "nuochoa.jpg", productPrice = 30000, mota = "Nước hoa với hương thơm quyến rũ, lưu hương lâu, thích hợp cho cả ngày dài." },
                    new Product() { id = 15, name = "Bóng da WC 2010", imageUrl = "bongda.jpg", productPrice = 45000, mota = "Quả bóng da WC 2010 chất lượng cao, thiết kế đặc biệt để tái hiện giải đấu nổi tiếng." },
                    new Product() { id = 16, name = "Aó da", imageUrl = "aoda.jpg", productPrice = 20000, mota = "Áo da thời trang, phong cách cá tính, chất liệu cao cấp, thích hợp cho mùa thu đông." },
                    new Product() { id = 17, name = "Nem chua nướng", imageUrl = "nemchuanuong.jpg", productPrice = 10000, mota = "Nem chua nướng thơm ngon, mang hương vị đặc trưng, rất phù hợp để thưởng thức như một món ăn vặt." },
                    new Product() { id = 18, name = "Cơm rang", imageUrl = "comrang.jpg", productPrice = 35000, mota = "Cơm rang thập cẩm đầy đủ dinh dưỡng với thịt, trứng và rau củ, món ăn phù hợp cho bữa trưa." },
                    new Product() { id = 19, name = "Hamburger", imageUrl = "hamboger.jpg", productPrice = 30000, mota = "Hamburger kiểu phương Tây, bánh mềm, thịt bò nướng chín tới, kèm phô mai và rau sống." },
                    new Product() { id = 20, name = "Trà chanh", imageUrl = "trachanh.jpg", productPrice = 15000, mota = "Trà chanh giải khát mát lạnh, vị chua nhẹ kết hợp với trà tươi, phù hợp cho những ngày hè." },

            };
            Application["Product"] = product;

        }
        protected void Session_Start(object sender, EventArgs e)
        {
            Session["User"] = new User();
            Session["Search"] = string.Empty;
            Session["Cart"] = new Cart();


        }

        public List<User> createUser()
        {
            return new List<User>()
             {
               new User() { email = "buitienk12km2@gmail.com", nameAccount = "VanTien", password = "@tiendzvd2003aA" },
             };
        }




        protected void Application_BeginRequest(object sender, EventArgs e) { }

        protected void Application_AuthenticateRequest(object sender, EventArgs e) { }

        protected void Application_Error(object sender, EventArgs e) { }

        protected void Session_End(object sender, EventArgs e) { }

        protected void Application_End(object sender, EventArgs e) { }

    }
}

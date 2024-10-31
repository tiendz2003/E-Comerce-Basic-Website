using BTL_Food.MasterPage;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace BTL_Food.data
{
    public class Cart
    {
        private List<CartItem> items;

        public Cart()
        {
            items = new List<CartItem>();
        }

        public void AddItem(CartItem item)
        {
            var existingItem = items.FirstOrDefault(i => i.FoodId == item.FoodId);
            if (existingItem != null)
            {
                // Nếu món ăn đã tồn tại, tăng số lượng
                existingItem.Quantity += item.Quantity;
            }
            else
            {
                // Nếu món ăn chưa tồn tại, thêm mới
                items.Add(item);
            }
        }


        public void RemoveItem(int foodId)
        {
            var item = items.FirstOrDefault(i => i.FoodId == foodId);
            if (item != null)
            {
                items.Remove(item);
            }
        }

        public List<CartItem> GetItems()
        {
            return items;
        }

        public decimal GetTotalValue(Func<int, decimal> priceLookup)
        {
            return items.Sum(item => priceLookup(item.FoodId) * item.Quantity);
        }
    }

    public class CartItem
    {
        public int FoodId { get; set; }
        public int Quantity { get; set; }
        public Product food { get; set; }

        public Double TotalPrice { get; set; }

        public CartItem(int foodId, int quantity, Product food)
        {
            FoodId = foodId;
            Quantity = quantity;
            this.food = food;
            TotalPrice = (double)(quantity * food.productPrice);
        }
       
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace BTL_Food.data
{
    public class Product
    {
        public int id { get; set; }
        public string name { get; set; }
        public string imageUrl { get; set; }
        public string mota { get; set; }
       
        public decimal productPrice { get; set; }
        public int Quantity { get; set; }
        
      
    }

}
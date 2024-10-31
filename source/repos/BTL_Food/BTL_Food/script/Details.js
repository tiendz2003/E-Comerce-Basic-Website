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
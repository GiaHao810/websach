var $ = document.querySelector.bind(document);
var $$ = document.querySelectorAll.bind(document);

if (document.readyState == 'loading') {
    document.addEventListener('DOMContentLoaded', ready)
} else {
    ready()
}

function ready() {
    const cartNull = $('.cart-content__null');

    const removeItemBtns = $$('.cart-content__item-drop');

    for (let i = 0; i < removeItemBtns.length; i++) {
        var removeItemBtn = removeItemBtns[i];
        removeItemBtn.onclick = (e) => { removeCartItem(e) }
    }

    const btnAdds = $$('.icon-cart');
    for (let i = 0; i < btnAdds.length; i++) {
        var btnAdd = btnAdds[i]
        btnAdd.onclick = (e) => { addToCartClick(e) }
    }

    var qntInputs = $$('.cart-content__item-qnt')
    for (let i = 0; i < qntInputs.length; i++) {
        var qntInput = qntInputs[i]
        qntInput.onchange = () => {updateTotal()}
    }
}

function addToCartClick(e) {
    var item = e.target.parentElement.parentElement.parentElement;
    if (e.target.className == 'ti-shopping-cart') {
        item = e.target.parentElement.parentElement.parentElement.parentElement;
    }

    var itemTitle = item.getElementsByClassName('content-product_item-title')[0].innerText
    var itemPrice = item.getElementsByClassName('content-product_item-price')[0].innerText
    var itemImg = item.getElementsByClassName('item-link-img')[0].src
    addItemToCart(itemTitle, itemPrice, itemImg);
}

function addItemToCart(title, price, img) {
    var cartBox = document.createElement('li')
    cartBox.classList.add('cart-content__item')
    var cartList = $$('.cart-content__list')[0];
    var cartItemTitle = cartList.getElementsByClassName('cart-content__item-title');
    var cartItemQnt = $$('.cart-content__item-qnt')[0]

    var cartItemQntValue = 1

    for(let i = 0; i< cartItemTitle.length; i++) {
        if (cartItemTitle[i].innerText == title) {
            alert('You have already add this item to cart');
            return;
        }
    }


    var cartItemDOM = ` <span class="cart-content__item-drop">
                            <i class="ti-close"></i>
                        </span>
                        <a href="#" class="cart-content__item-link">
                            <img src="${img}" alt="book-cart">
                        </a>
                        <div class="wrap-item">
                            <h3 class="cart-content__item-title">${title}</h3>
                            <div class="cart-content__info">
                            <input type="number" class="cart-content__item-qnt" min="1" max step="1" value="1">
                                <h3 class="cart-content__item-mul">x</h3>
                                <h3 class="cart-content__item-price">${price}</h3>
                            </div>
                        </div>`
    cartBox.innerHTML = cartItemDOM
    cartList.append(cartBox)
    updateTotal()
    cartBox.getElementsByClassName('cart-content__item-drop')[0].onclick = (e) => {removeCartItem(e)}
    cartBox.getElementsByClassName('cart-content__item-qnt')[0].onchange = () => {updateTotal()}
}

function removeCartItem(e) {
    var item = e.target.parentElement.parentElement;
    if (e.target.className == 'cart-content__item-drop') {
        item = e.target.parentElement;
    }
    item.remove();
    updateTotal();
}

function updateTotal() {
    const cartList = $('.cart-content__list');
    const cartItems = $$('.cart-content__item');
    const totalValue = $('.cart-content__total-value');
    var total = 0

    for (var i = 0; i < cartItems.length; i++) {
        var cartItem = cartItems[i]
        var cartItemPrice = parseFloat(cartItem.getElementsByClassName('cart-content__item-price')[0].innerText.replace('$', ''))
        var cartItemQnt = Number(cartItem.getElementsByClassName('cart-content__item-qnt')[0].value)

        var total = total + cartItemPrice * cartItemQnt
    }

    total = Math.round(total * 100) / 100;

    totalValue[0].innerText = '$' + total.toFixed(2)
}
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ page import="org.apache.commons.codec.binary.*" %>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Books Online</title>

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/lykmapipo/themify-icons@0.1.2/css/themify-icons.css">

        <link rel="stylesheet"
            href="https://fonts.googleapis.com/css2?family=DM+Sans:wght@400;500;700&family=Shantell+Sans:wght@300;400;500;600&display=swap">

        <link rel="stylesheet" href="./assets/css/grid.css">
        <link rel="stylesheet" href="./assets/css/base.css">
        <link rel="stylesheet" href="./assets/css/style.css">

        <link rel="stylesheet" href="./assets/css/slick.css">
        <link rel="stylesheet" href="./assets/css/slick-theme.css">
    </head>

    <body>
        <header>
            <div class="grid wide">
                <div class="row">
                    <div class="header-left col l-4">
                        <ul class="header-nav row">
                            <li class="header-nav__item l-3">
                                <a href="http://localhost:8080/websach/home"
                                    class="header-nav__item-link header-nav__item-link--active">Home</a>
                            </li>
                            <li class="header-nav__item l-3">
                                <a href="#" class="header-nav__item-link">Pages</a>
                            </li>
                            <li class="header-nav__item l-3">
                                <a href="#" class="header-nav__item-link">Blog</a>
                            </li>
                            <li class="header-nav__item l-3">
                                <a href="#" class="header-nav__item-link">Shop</a>
                            </li>
                        </ul>
                    </div>
                    <div class="header-midle col l-4">
                        <h1 class="header-logo">Books Online</h1>
                    </div>
                    <div class="header-right col l-4">
                        <div class="row">
                            <label for="cart-list__input" class="cart">
                                <i class="ti-bag"></i>
                            </label>
                            <input hidden type="checkbox" class="cart-list_checked" id="cart-list__input">
                            <!-- <div class="cart-list">
                            <div class="cart-content">
                                <div class="cart-content__null">
                                    <i class="ti-bag"></i>
                                    <p>No product in the cart</p>
                                </div>
                                <ul class="cart-content__list">
                                    <li class="cart-content__item">
                                        <span class="cart-content__item-drop">
                                            <i class="ti-close"></i>
                                        </span>
                                        <a href="#" class="cart-content__item-link">
                                            <img src="./assets/img/book.jpg" alt="book-cart">
                                        </a>
                                        <div class="wrap-item">
                                            <h3 class="cart-content__item-title">Gardening A</h3>
                                            <div class="cart-content__info">
                                                <div class="item-wrap">
                                                    <input type="number" class="cart-content__item-qnt" min="1" max
                                                        step="1" value="1">
                                                </div>
                                                <h3 class="cart-content__item-mul">x</h3>
                                                <h3 class="cart-content__item-price">$22.02</h3>
                                            </div>
                                        </div>
                                    </li>
                                    <li class="cart-content__item">
                                        <span class="cart-content__item-drop">
                                            <i class="ti-close"></i>
                                        </span>
                                        <a href="#" class="cart-content__item-link">
                                            <img src="./assets/img/book.jpg" alt="book-cart">
                                        </a>
                                        <div class="wrap-item">
                                            <h3 class="cart-content__item-title">Gardening B</h3>
                                            <div class="cart-content__info">
                                                <div class="item-wrap">
                                                    <input type="number" class="cart-content__item-qnt" min="1" max
                                                        step="1" value="1">
                                                </div>
                                                <h3 class="cart-content__item-mul">x</h3>
                                                <h3 class="cart-content__item-price">$22.00</h3>
                                            </div>
                                        </div>
                                    </li>
                                    <li class="cart-content__item">
                                        <span class="cart-content__item-drop">
                                            <i class="ti-close"></i>
                                        </span>
                                        <a href="#" class="cart-content__item-link">
                                            <img src="./assets/img/book.jpg" alt="book-cart">
                                        </a>
                                        <div class="wrap-item">
                                            <h3 class="cart-content__item-title">Gardening C</h3>
                                            <div class="cart-content__info">
                                                <div class="item-wrap">
                                                    <input type="number" class="cart-content__item-qnt" min="1" max
                                                        step="1" value="1">
                                                </div>
                                                <h3 class="cart-content__item-mul">x</h3>
                                                <h3 class="cart-content__item-price">$22.00</h3>
                                            </div>
                                        </div>
                                    </li>
                                </ul>
                                <div class="cart-content__total">
                                    <p class="cart-content__total-lable">Subtotal: </p>
                                    <p class="cart-content__total-value">$66.02</p>
                                </div>
                                <div class="cart-content__btn">
                                    <a href="#" class="btn cart-content__btn-buy">Buy</a>
                                </div>
                            </div>
                        </div> -->

                            <label for="search-wrap_input" class="search">
                                <i class="ti-search"></i>
                            </label>
                            <input hidden type="checkbox" class="search-wrap_checked" id="search-wrap_input">
                            <div class="search-wrap">
                                <div class="search-wrap_header grid wide">
                                    <h1 class="header-logo">Books Online</h1>
                                    <label for="search-wrap_input" class="search-wrap_close">
                                        <i class="ti-close"></i>
                                    </label>
                                </div>
                                <div class="search-wrap_from grid wide">
                                    <form action="">
                                        <input type="text" placeholder="Type words and hit enter">
                                        <button class="btn"><i class="ti-search"></i></button>
                                    </form>
                                </div>
                            </div>

                            <label for="account-bar_input" class="account">
                                <i class="fa-regular fa-circle-user"></i>
                            </label>
                            <input hidden type="checkbox" class="account-bar_checked" id="account-bar_input">
                            <div class="account-bar">
                                <div class="account-bar__logouted">
                                    <div class="wrap-item">
                                        <a href="./login.html" class="account-login">
                                            <i class="fa-solid fa-arrow-right-from-bracket"></i>
                                            <p>Log in</p>
                                        </a>
                                        <label for="account-bar_input" class="account-bar__close">
                                            <i class="ti-close"></i>
                                        </label>
                                    </div>
                                    <a href="#" class="account-register">
                                        <i class="fa-regular fa-registered"></i>
                                        <p>Register</p>
                                    </a>
                                </div>
                                <div class="account-bar__logined">
                                    <div class="account-bar__header">
                                        <h1 class="account-name">Name</h1>
                                        <label for="account-bar_input" class="account-bar__close">
                                            <i class="ti-close"></i>
                                        </label>
                                    </div>
                                    <span class="account-email">
                                        <i class="ti-email"></i>
                                        <p>Email</p>
                                    </span>
                                    <span class="account-addrs">
                                        <i class="ti-location-arrow"></i>
                                        <p>Address</p>
                                    </span>
                                    <a href="#" class="account-logout">
                                        <i class="fa-solid fa-arrow-right-from-bracket"></i>
                                        <p>Log out</p>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </header>

        <div class="content">
            <div class="grid wide">
                <div class="content-title">
                    <p class="content-text">Shop online</p>
                    <h1 class="content-bestsale">Books Bestsellers</h1>
                </div>
                <div class="content-product">
                    <ul class="content-product_list row">
                        <c:forEach items="${productList}" var="item">
                            <li class="content-product_item col l-3">
                                <div class="content-product_item-interact item-wrap">
                                    <a href="#" class="content-product_item-link">
                                        <img class="item-link-img" src="data:image/jpeg;base64,${fn:escapeXml(item.image_url)}" alt="book item">
                                    </a>
                                    <div class="icons-interact">
                                        <span class="icon-cart">
                                            <i class="ti-shopping-cart"></i>
                                        </span>
                                        <a href="http://localhost:8080/websach/book?id=${item.book_id}" class="icon-detail">
                                            <i class="ti-arrow-right"></i>
                                        </a>
                                    </div>
                                </div>
                                <h2 class="content-product_item-title">
                                    ${item.title}
                                </h2>
                                <div class="start-rating">
                                    <ul>
                                        <li><i class="star-icon star-icon--fill fa-solid fa-star"></i></li>
                                        <li><i class="star-icon star-icon--fill fa-solid fa-star"></i></li>
                                        <li><i class="star-icon star-icon--fill fa-solid fa-star"></i></li>
                                        <li><i class="star-icon star-icon--fill fa-solid fa-star"></i></li>
                                        <li><i class="star-icon star-icon--fill fa-solid fa-star"></i></li>
                                    </ul>
                                </div>
                                <p class="content-product_item-price">${item.price}</p>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>

        <footer>

        </footer>
    </body>
>

    </html>
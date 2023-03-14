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
    <title>Detail Books</title>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/lykmapipo/themify-icons@0.1.2/css/themify-icons.css">

    <link rel="stylesheet"
        href="https://fonts.googleapis.com/css2?family=DM+Sans:wght@400;500;700&family=Shantell+Sans:wght@300;400;500;600&display=swap">

    <link rel="stylesheet" href="./assets/css/grid.css">
    <link rel="stylesheet" href="./assets/css/base.css">
    <link rel="stylesheet" href="./assets/css/style.css">

    <link rel="stylesheet" href="./assets/css/styleDetail.css">
</head>

<body>
    <header>
        <div class="grid wide">
            <div class="row">
                <div class="header-midle col l-5">
                    <h1 class="header-logo">Books Online</h1>
                </div>
                <div class="header-left col l-5">
                    <ul class="header-nav row">
                        <li class="header-nav__item l-3">
                            <a href="http://localhost:8080/websach/home" class="header-nav__item-link">Home</a>
                        </li>
                        <li class="header-nav__item l-3">
                            <a href="#" class="header-nav__item-link">Pages</a>
                        </li>
                        <li class="header-nav__item l-3">
                            <a href="#" class="header-nav__item-link">Blog</a>
                        </li>
                        <li class="header-nav__item l-3">
                            <a href="#" class="header-nav__item-link header-nav__item-link--active">Shop</a>
                        </li>
                    </ul>
                </div>
                <div class="header-right col l-2">
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
                                    <p class="cart-content__total-value">$0.00</p>
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
                                <input type="text" placeholder="Type words and hit enter">
                                <button class="btn"><i class="ti-search"></i></button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </header>

    <div class="content">
        <div class="grid wide">
            <div class="row">
                <div class="book-img col l-6">
                    <img src="data:image/jpeg;base64,${fn:escapeXml(image_url)}"/>
                </div>
                <div class="book-detail col l-6">
                    <h1 class="book-title">${title}</h1>
                    <span class="book-author text-detail">
                        <span class="book-author__lable">Author: </span>
                        <span class="book-author__value">${name_a}</span>
                    </span>
                    <span class="book-rate">
                        <div class="row">
                            <p class="book-price col l-6">${price}</p>
                            <div class="start-rating col l-6">
                                <ul>
                                    <li><i class="star-icon star-icon--fill fa-solid fa-star"></i></li>
                                    <li><i class="star-icon star-icon--fill fa-solid fa-star"></i></li>
                                    <li><i class="star-icon star-icon--fill fa-solid fa-star"></i></li>
                                    <li><i class="star-icon star-icon--fill fa-solid fa-star"></i></li>
                                    <li><i class="star-icon star-icon--fill fa-solid fa-star"></i></li>
                                </ul>
                            </div>
                        </div>
                    </span>
                    <div class="book-decs text-detail">
                        <p>${description}</p>
                    </div>
                    <!-- <table class="book-info text-detail">
                        <tbody>
                            <tr class="book-publisher">
                                <th class="book-publisher__lable">Publisher: </th>
                                <td class="book-publisher__value">Name</td>
                            </tr>
                            <tr class="book-year">
                                <th class="book-year__lable">Year of Publisher: </th>
                                <td class="book-year__value">Year</td>
                            </tr>
                            <tr class="book-pages">
                                <th class="book-pages__lable">Number of pages: </th>
                                <td class="book-pages__value">Number</td>
                            </tr>
                        </tbody>
                    </table> -->
                    <!-- <span class="book-total book-price">$22.00</span> -->
                    <div class="book-quantity">
                        <div class="row">
                            <!-- <div class="item-wrap">
                                <input type="number" class="book-count" min="1" max step="1" value="1">
                                <span class="book-count__inc"><i class="ti-angle-up"></i></span>
                                <span class="book-count__dec"><i class="ti-angle-down"></i></span>
                            </div> -->

                            <form action="">
                                <button class="btn book-btn">
                                    <i class="ti-shopping-cart"></i>
                                    Add to cart
                                </button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <footer>

    </footer>
</body>

<!-- <script src="./assets/js/addtocartDetail.js"></script> -->

</html>
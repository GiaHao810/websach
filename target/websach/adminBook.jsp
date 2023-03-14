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
            <link rel="stylesheet"
                href="https://cdn.jsdelivr.net/gh/lykmapipo/themify-icons@0.1.2/css/themify-icons.css">

            <link rel="stylesheet"
                href="https://fonts.googleapis.com/css2?family=DM+Sans:wght@400;500;700&family=Shantell+Sans:wght@300;400;500;600&display=swap">

            <link rel="stylesheet" href="./assets/css/grid.css">
            <link rel="stylesheet" href="./assets/css/base.css">
            <link rel="stylesheet" href="./assets/css/style.css">

            <link rel="stylesheet" href="./assets/css/styleAdmin.css">
        </head>

        <body>
            <header>
                <div class="grid wide">
                    <div class="row">

                        <div class="header-midle col l-12">
                            <h1 class="header-logo">Books Online</h1>
                        </div>

                    </div>
                </div>
            </header>

            <div class="content grid wide">
                <div class="row">
                    <div class="category col l-2">
                        <div class="category-wrap">
                            <a href="#" class="category-home">
                                <i class="ti-home"></i>
                                Home
                            </a>
                            <a href="#" class="category-book category-active">
                                <i class="ti-book"></i>
                                Books
                            </a>
                            <a href="#" class="category-user">
                                <i class="fa-regular fa-circle-user"></i>
                                Users
                            </a>
                            <a href="#" class="category-author">
                                <i class="ti-marker-alt"></i>
                                Authors
                            </a>
                        </div>
                    </div>
                    <div class="manager col l-10">
                        <div class="manager-book">
                            <a href="#" class="manager-book__add">
                                Add new book
                            </a>
                            <table class="manager-table">
                                <thead class="manager-header">
                                    <tr role="row">
                                        <th>Book ID</th>
                                        <th class="manager-book__img-lable">Book Image</th>
                                        <th>Book Name</th>
                                        <th>Book Description</th>
                                        <th>Book Price</th>
                                        <th>Actions</th>
                                    </tr>
                                </thead>
                                <tbody class="manager-content">
                                    <c:forEach items="${Booklist}" var="item">
                                        <tr role="row" class="odd">
                                            <td>${item.book_id}</td>
                                            <td>
                                                    <img class="manager-book__img" src="data:image/jpeg;base64,${fn:escapeXml(base64EncodedImage)}" alt="book item">
                                            </td>
                                            <td>${item.title}</td>
                                            <td class="manager-book__desc">
                                                <p>${item.description}</p>
                                            </td>
                                            <td>${item.price}</td>
                                            <td>
                                                <div class="manager-book__action">
                                                    <a href="#" class="manager-book__edit">
                                                        <i class="ti-pencil-alt"></i>
                                                    </a>
                                                    <a href="#" class="manager-book__drop">
                                                        <i class="ti-trash"></i>
                                                    </a>
                                                </div>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>

                        <div class="manager-add">
                            <div class="add-book">
                                <form action="">
                                    <div class="add-book__name form-group">
                                        <label for="book-name" class="add-book__name-lable form-label">Book
                                            Name:</label>
                                        <input class="form-input" id="book-name" type="text" placeholder="Book Name">
                                    </div>
                                    <div class="add-book__author form-group">
                                        <label for="book-author" class="add-book__author-lable form-label">Book
                                            Author:</label>
                                        <input class="form-input" id="book-author" type="text"
                                            placeholder="Book Author">
                                    </div>
                                    <div class="add-book__price form-group">
                                        <label for="book-price" class="add-book__price-lable form-label">Book
                                            Price:</label>
                                        <input class="form-input" id="book-name" type="number" min="1000" step="500"
                                            value="1000">
                                    </div>
                                    <div class="add-book__desc form-group">
                                        <label for="book-desc" class="add-book__desc-lable form-label">Book
                                            Description:</label>
                                        <textarea name="" id="" cols="30" rows="10"
                                            class="form-input form-input__desc"></textarea>
                                    </div>
                                    <div class="add-book__img form-group">
                                        <label for="book-img" class="add-book__img-lable form-label">Book Image:</label>
                                        <div class="custom-from">
                                            <input class="form-input form-input__img" id="book-img" type="file"
                                                accept="image/png, image/jpeg">
                                            <label class="custom-from__label" for="book-img">Choose file</label>
                                        </div>
                                    </div>
                                    <div class="add-book__btn form-group">
                                        <button class="btn btn-submit btn-book__submit">Submit</button>
                                        <button class="btn btn-reset btn-book__reset">Reset</button>
                                    </div>
                                </form>
                            </div>
                        </div>

                    </div>
                </div>
            </div>

            <footer>

            </footer>
        </body>

        <script src="./assets/js/mainAdminBook.js"></script>

        </html>
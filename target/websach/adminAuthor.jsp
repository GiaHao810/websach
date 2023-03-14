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
                    <a href="#" class="category-book">
                        <i class="ti-book"></i>
                        Books
                    </a>
                    <a href="#" class="category-user">
                        <i class="fa-regular fa-circle-user"></i>
                        Users
                    </a>
                    <a href="#" class="category-author">
                        <i class="ti-marker-alt category-active"></i>
                        Authors
                    </a>
                </div>
            </div>
            <div class="manager col l-10">
                <div class="manager-author">
                    <a href="#" class="manager-author__add">
                        Add new author
                    </a>
                    <table class="manager-table">
                        <thead class="manager-header">
                            <tr role="row">
                                <th>Authors ID</th>
                                <th>Authors Email</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody class="manager-content">
                            <c:forEach items="${authorlist}" var="item">
                                <tr role="row" class="odd">
                                    <td>${item.author_id}</td>
                                    <td>${item.name_a}</td>
                                    <td>
                                        <div class="manager-author__action">
                                            <a href="#" class="manager-author__edit">
                                                <i class="ti-pencil-alt"></i>
                                            </a>
                                            <a href="#" class="manager-author__drop">
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
                    <div class="add-author">
                        <form action="">
                            <div class="add-author__name form-group">
                                <label for="user-name" class="add-author__name-lable form-label">Author Name:</label>
                                <input class="form-input" id="user-name" type="text" placeholder="Author Name">
                            </div>
                            <div class="add-author__btn form-group">
                                <button class="btn btn-submit btn-author__submit">Submit</button>
                                <button class="btn btn-reset btn-author__reset">Reset</button>
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

<script src="./assets/js/mainAdminAuthor.js"></script>

</html>
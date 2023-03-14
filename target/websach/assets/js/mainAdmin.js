var $ = document.querySelector.bind(document);
var $$ = document.querySelectorAll.bind(document);

const bookLable = $('.category-book')
const bookTable = $('.manager-book')
const userLable = $('.category-user')
const userTable = $('.manager-user')

const editBtns = $$('.manager-book__edit')

userLable.onclick = () => {
    bookTable.style.display = 'none'
    userTable.style.display = 'block'

    bookLable.classList.remove('category-active')
    userLable.classList.add('category-active')
}

bookLable.onclick = () => {
    userTable.style.display = 'none'
    bookTable.style.display = 'block'

    userLable.classList.remove('category-active')
    bookLable.classList.add('category-active')
}

// add-book-btn click
const addBookBtn = $('.manager-book__add')
const addBookPage = $('.add-book')
const bookSubmitBtn = $('.btn-book__submit')

addBookBtn.onclick = () => {
    bookTable.style.display = 'none'
    userTable.style.display = 'none'
    addBookPage.style.display = 'block'
    addUserPage.style.display = 'none'
}

bookSubmitBtn.onclick = () => {
    bookTable.style.display = 'block'
    userTable.style.display = 'none'
    addBookPage.style.display = 'none'
    addUserPage.style.display = 'none'
}

// add user-btn click
const addUserBtn = $('.manager-user__add')
const addUserPage = $('.add-user')
const userSubmitBtn = $('.btn-user__submit')

addUserBtn.onclick = () => {
    bookTable.style.display = 'none'
    userTable.style.display = 'none'
    addBookPage.style.display = 'none'
    addUserPage.style.display = 'block'
}

userSubmitBtn.onclick = () => {
    bookTable.style.display = 'none'
    userTable.style.display = 'block'
    addBookPage.style.display = 'none'
    addUserPage.style.display = 'none'
}
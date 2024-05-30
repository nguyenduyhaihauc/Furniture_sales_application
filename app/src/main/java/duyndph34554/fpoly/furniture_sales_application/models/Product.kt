package duyndph34554.fpoly.furniture_sales_application.models

class Product(val image: Int, val name: String, val price: Double) {
    var quantity: Int = 0

    constructor(image: Int, name: String, price: Double, quantity: Int) : this (image, name, price) {
        this.quantity = quantity
    }
}
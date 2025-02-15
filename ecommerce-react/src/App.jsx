import { useState } from 'react'
import './App.css'
import { useEffect } from 'react';
import ProductList from './ProductList';
import CategoryFilter from './CategoryFilter';

function App() {
  const [products, setProducts] = useState([]);
  const [categories, setCategories] = useState([]);
  const [selectedCategory, setSelectedCategory] = useState(null);
  const [searchTerm, setSearchTerm] = useState("");
  const [sortOrder, setSortOrder] = useState("asc");
  const [cart, setCart] = useState([]);
  const [showCart, setShowCart] = useState(false);

  useEffect(() =>  {
    fetch("http://localhost:8080/api/products")
      .then(response => response.json())
      .then(data => setProducts(data));

    fetch("http://localhost:8080/api/categories")
      .then(response => response.json())
      .then(data => setCategories(data));
  }, []);

  const handleSearchChange = (event) => {
    setSearchTerm(event.target.value);
  };

  const handleSortChange = (event) => {
    setSortOrder(event.target.value);
  };

  const handleCategorySelect = (categoryId) => {
    setSelectedCategory(categoryId ? Number(categoryId) : null);
  };

  const addToCart = (product) => {
    setCart((prevCart) => [...prevCart, product]);
  };

  const toggleCart = () => {
    setShowCart(!showCart);
  };

  const totalAmount = cart.reduce((sum, product) => sum + product.price, 0);

  const filteredProducts = products
          .filter(product => {
            return(
              (selectedCategory ? product.category.id === selectedCategory : true)
              && 
              product.name.toLowerCase().includes(searchTerm.toLowerCase())
            )
          })
          .sort((a, b) => (sortOrder === "asc" ? a.price - b.price : b.price - a.price));

  return (
    <div className='container' >
      <h1 className='my-4'>AsH's Store</h1>

      <div className="cart-icon" onClick={toggleCart}>
        🛒 <span className="cart-count">{cart.length}</span>
      </div>

      <div className='row align-items-center mb-4'>
        <div className='col-md-3 col-sm-12 mb-2'>
          <CategoryFilter categories={categories} onSelect={handleCategorySelect} />
        </div>
        <div className='col-md-5 col-sm-12 mb-2'>
          <input type="text"
            className='form-control'
            placeholder='Search for Products'
            onChange={handleSearchChange}/>
        </div>
        <div className='col-md-4 col-sm-12 mb-2'>
          <select className='form-control' onChange={handleSortChange}>
            <option value="asc">Sort by Price : Low to High</option>
            <option value="desc">Sort by Price : High to Low</option>
          </select>
        </div>
      </div>

      <div>
        {filteredProducts.length ? (
          <ProductList products={filteredProducts} addToCart={addToCart} />
        ) : (<p>No Products Found !</p>)}
      </div>

      {showCart && (
        <div className="cart-popup">
          <h3>🛍️ Your Cart</h3>
          {cart.length === 0 ? (
            <p>Your cart is empty</p>
          ) : (
            <>
              <ul>
                {cart.map((item, index) => (
                  <li key={index}>
                    {item.name} - ${item.price.toFixed(2)}
                  </li>
                ))}
              </ul>
              <p><strong>Total :</strong> ${totalAmount.toFixed(2)}</p>
            </>
          )}
          <button onClick={toggleCart}>Close</button>
        </div>
      )}
    </div>  
  )
}

export default App

const ProductList = ({ products, addToCart }) => {
    return (
        <div className="row">
            {products.map(product => (
                <div className="col-lg-4 col-md-6  col-sm-12 mb-4" key={product.id}>
                    <div className="card h-100">
                        <img src={`http://localhost:8080${product.imageURL}`}
                        className="card-img-top"
                        alt={product.name}
                        style={{ width: "100%", height: "200px", objectFit: "cover" }}/>
                        <div className="card-body">
                            <h5 className="card-title">{product.name}</h5>
                            <p className="card-text">{product.description}</p>
                            <p className="card-text"><strong>${product.price.toFixed(2)}</strong></p>
                            <button className="btn btn-success" onClick={() => addToCart(product)}>
                                Add to Cart
                            </button>
                        </div>
                    </div>
                </div>
            ))}
        </div>
    )
}

export default ProductList
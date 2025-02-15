const CategoryFilter = ({ categories, onSelect }) => {

    return (
        <>
            <select id="categorySelect" className="form-control" onChange={(e) => onSelect(e.target.value)}>
                <option>All Categories</option>
                {categories.map(categorie => (
                    <option key={categorie.id} value={categorie.id}>{categorie.name}</option>
                ))}
            </select>
        </>
    )
}

export default CategoryFilter
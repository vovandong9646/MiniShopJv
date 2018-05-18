<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--header--%>
<c:import url="header.jsp"/>
<%--end header--%>

<div class="container">
    <div class="row" style="padding:20px 10px;">
        <div class="col-md-6">
            <form>
                <select class="form-control" name="typeProductEntity" id="typeProduct">
                    <c:forEach items="${danhmuc}" var="dm">
                        <option value="${dm.getId()}">${dm.getName()}</option>
                    </c:forEach>
                </select>
                <input type="text" name="name" class="form-control" id="name" placeholder="Enter name">
                <input type="number" name="unitPrice" class="form-control" id="unitPrice" placeholder="Enter Unit Price">
                <input type="number" name="promotionPrice" class="form-control" id="promotionPrice" placeholder="Enter Promotion Price">
                <input type="file" name="image" class="form-control" id="image" placeholder="Enter Image">
                <input type="text" name="unit" class="form-control" id="unit" placeholder="Enter Unit">
                <div class="input-group-text">
                    <input type="radio" name="news" id="new" value="1" checked />New<br>
                    <input type="radio" name="news" id="old" value="0"/>Old
                </div>
                <textarea name="description" cols="10" rows="10" class="form-control"></textarea>
                <input type="submit" id="addProduct" value="Add Product" class="btn btn-outline-primary"/>
                <input type="submit" id="updateProduct" value="Update Product" class="btn btn-outline-info"/>
            </form>
        </div>
        <div class="col-md-6">
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Name</th>
                    <th scope="col">Type</th>
                    <th scope="col">Price</th>
                    <th scope="col">Action</th>
                </tr>
                </thead>
                <tbody>
                <c:set var="stt" value="1"/>
                <c:forEach items="${listProducts}" var="product">
                    <tr>
                        <th scope="row">${stt}</th>
                        <td>${product.getName()}</td>
                        <td>${product.getTypeProductEntity().getName()}</td>
                        <td>${product.getPromotionPrice() !=0 ? product.getPromotionPrice() : product.getUnitPrice() }</td>
                        <td>
                            <button class="btn btn-primary editProduct" data-id="${product.getId()}">Edit</button>
                            <button class="btn btn-danger deleteProduct" data-id="${product.getId()}">Delete</button>
                        </td>
                    </tr>
                    <c:set var="stt" value="${stt+1}"/>
                </c:forEach>

                </tbody>

            </table>
            <nav aria-label="Page navigation example">
                <ul class="pagination text-center">
                    <li class="page-item"><a class="page-link" href="#">Previous</a></li>
                     <c:forEach step="1" begin="1" end="${totalPage}" var="tt">
                         <c:choose>
                             <c:when test="${tt == 1}">
                                 <li class="page-item active">
                                     <a class="page-link paginate" href="">${tt}</a>
                                 </li>
                             </c:when>
                             <c:otherwise>
                                 <li class="page-item">
                                     <a class="page-link paginate" href="">${tt}</a>
                                 </li>
                             </c:otherwise>
                         </c:choose>

                    </c:forEach>
                    <li class="page-item"><a class="page-link" href="">Next</a></li>
                </ul>
            </nav>
        </div>
    </div>
</div> <!-- .container -->
<%--end content--%>

<%--footer--%>
<c:import url="footer.jsp"/>
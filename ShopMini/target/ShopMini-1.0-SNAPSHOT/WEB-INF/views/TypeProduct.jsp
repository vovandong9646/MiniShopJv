<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--header--%>
<c:import url="header.jsp"/>
<%--end header--%>

<%--content--%>
<div class="inner-header">
    <div class="container">
        <div class="pull-left">
            <h6 class="inner-title">Loai Banh: ${listProductByType.get(0).getTypeProductEntity().getName()}</h6>
        </div>
        <div class="pull-right">
            <div class="beta-breadcrumb font-large">
                <a href="index.html">Home</a> / <span>Sản phẩm</span>
            </div>
        </div>
        <div class="clearfix"></div>
    </div>
</div>
<div class="container">
    <div id="content" class="space-top-none">
        <div class="main-content">
            <div class="space60">&nbsp;</div>
            <div class="row">
                <div class="col-sm-3">
                    <ul class="aside-menu">
                        <c:forEach items="${danhmuc}" var="dm">
                            <li><a href="/danhmuc/${dm.getId()}">${dm.getName()}</a></li>
                        </c:forEach>
                    </ul>
                </div>
                <div class="col-sm-9">
                    <div class="beta-products-list">
                        <h4>New Products</h4>
                        <div class="beta-products-details">
                            <p class="pull-left">438 styles found</p>
                            <div class="clearfix"></div>
                        </div>

                        <div class="row">
                            <c:forEach items="${listProductByType}" var="product">
                                <div class="col-sm-3" style="margin-top:10px;">
                                    <div class="single-item">
                                        <div class="single-item-header">
                                            <a href="<c:url value='/sanpham/${product.getId()}/chitiet'/>"><img style="height:200px;" src="<c:url value='/resources/image/product/${product.image}'/>" alt=""></a>
                                        </div>
                                        <div class="single-item-body">
                                            <p class="single-item-title">${product.name}</p>
                                            <p class="single-item-price" style="height:50px;">
                                                <c:choose>
                                                    <c:when test="${product.getPromotionPrice() != 0}">
                                                        <span class="flash-del">$ ${product.getUnitPrice()}</span><br>
                                                        <span class="flash-sale">$ ${product.getPromotionPrice()}</span>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <span class="flash-sale">$ ${product.getUnitPrice()}</span>
                                                    </c:otherwise>
                                                </c:choose>
                                            </p>
                                        </div>
                                        <div class="single-item-caption">
                                            <a class="add-to-cart pull-left" href="shopping_cart.html"><i class="fa fa-shopping-cart"></i></a>
                                            <a class="beta-btn primary" href="<c:url value='/sanpham/${product.getId()}/chitiet'/>">Details <i class="fa fa-chevron-right"></i></a>
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                            <div class="space50">&nbsp;</div>
                        </div>
                    </div> <!-- .beta-products-list -->

                    <nav aria-label="Page navigation example" class="text-center">
                        <ul class="pagination">
                            <li class="page-item"><a class="page-link" href="#">Previous</a></li>
                            <c:forEach begin="1" end="${soTrang}" step="1" var="st">
                                <li class="page-item">
                                    <a class="page-link" href="/danhmuc/${listProductByType.get(0).typeProductEntity.id}/${st}">${st}</a>
                                </li>
                            </c:forEach>
                            <li class="page-item"><a class="page-link" href="#">Next</a></li>
                        </ul>
                    </nav>


                </div>
            </div> <!-- end section with sidebar and main content -->


        </div> <!-- .main-content -->
    </div> <!-- #content -->
</div> <!-- .container -->

<%--footer--%>
<c:import url="footer.jsp"/>
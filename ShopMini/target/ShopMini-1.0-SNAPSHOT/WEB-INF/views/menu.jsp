<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="header-bottom" style="background-color: #0277b8;">
    <div class="container">
        <a class="visible-xs beta-menu-toggle pull-right" href="#"><span class='beta-menu-toggle-text'>Menu</span> <i class="fa fa-bars"></i></a>
        <div class="visible-xs clearfix"></div>
        <nav class="main-menu">
            <ul class="l-inline ov">
                <li><a href="<c:url value='/'/>">Trang chủ</a></li>
                <li><a href="#">Sản phẩm</a>
                    <ul class="sub-menu">
                        <c:forEach items="${danhmuc}" var="dm">
                            <li><a href="<c:url value="/danhmuc/${dm.getId()}/1"/>">${dm.getName()}</a></li>
                        </c:forEach>
                    </ul>
                </li>
                <li><a href="/themSanPham">Thêm Sản Phẩm</a></li>
                <li><a href="contacts.html">Liên hệ</a></li>
            </ul>
            <div class="clearfix"></div>
        </nav>
    </div> <!-- .container -->
</div> <!-- .header-bottom -->
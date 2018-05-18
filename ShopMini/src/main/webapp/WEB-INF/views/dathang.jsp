<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--header--%>
<c:import url="header.jsp"/>
<%--end header--%>

<%--content--%>
<div class="inner-header">
    <div class="container">
        <div class="pull-left">
            <h6 class="inner-title">Đặt hàng</h6>
        </div>
        <div class="pull-right">
            <div class="beta-breadcrumb">
                <a href="index.html">Trang chủ</a> / <span>Đặt hàng</span>
            </div>
        </div>
        <div class="clearfix"></div>
    </div>
</div>

<div class="container">
    <div id="content">

        <form action="<c:url value='/dathang'/>" method="post" modelAttribute="customer" class="beta-form-checkout">
            <div class="row">
                <div class="col-sm-6">
                    <h4>Đặt hàng</h4>
                    <div class="space20">&nbsp;</div>

                    <div class="form-block">
                        <label for="name">Họ tên*</label>
                        <input type="text" value="${customer.name}" name="name" id="name" placeholder="Họ tên" required>
                    </div>
                    <div class="form-block">
                        <label>Giới tính </label>
                        <c:choose>
                            <c:when test="${'nam'.equals(customer.gender.toLowerCase())}">
                                <input id="gender" type="radio" class="input-radio" name="gender" value="nam" checked="checked" style="width: 10%"><span style="margin-right: 10%">Nam</span>
                                <input id="gender" type="radio" class="input-radio" name="gender" value="nữ" style="width: 10%"><span>Nữ</span>
                            </c:when>
                            <c:otherwise>
                                <input id="gender" type="radio" class="input-radio" name="gender" value="nam" style="width: 10%"><span style="margin-right: 10%">Nam</span>
                                <input id="gender" type="radio" class="input-radio" name="gender" value="nữ" checked="checked" style="width: 10%"><span>Nữ</span>
                            </c:otherwise>
                        </c:choose>



                    </div>

                    <div class="form-block">
                        <label for="email">Email*</label>
                        <input type="email" value="${customer.email}" name="email" id="email" required placeholder="expample@gmail.com">
                    </div>

                    <div class="form-block">
                        <label for="adress">Địa chỉ*</label>
                        <input type="text" value="${customer.address}" name="address" id="adress" placeholder="Street Address" required>
                    </div>


                    <div class="form-block">
                        <label for="phone">Điện thoại*</label>
                        <input type="text" value="${customer.phoneNumber}" name="phoneNumber" id="phone" required>
                    </div>

                    <div class="form-block">
                        <label for="notes">Ghi chú</label>
                        <textarea name="note" id="notes">${customer.note}</textarea>
                    </div>
                </div>
                <div class="col-sm-6">
                    <div class="your-order">
                        <div class="your-order-head"><h5>Đơn hàng của bạn</h5></div>
                        <div class="your-order-body" style="padding: 0px 10px">
                            <div class="your-order-item">
                                <div>
                                    <!--  one item	 -->
                                    <% float total = 0; %>
                                    <c:forEach items="${cart}" var="giohang">
                                        <div class="media">
                                            <img width="25%" src="<c:url value='/resources/image/product/${giohang.getProductEntity().getImage()}'/>" alt="" class="pull-left">
                                            <div class="media-body">
                                                <p class="font-large">${giohang.getProductEntity().getName()}</p>
                                                <span class="color-gray your-order-info">Color: Red</span>
                                                <span class="color-gray your-order-info">Size: M</span>
                                                <span class="color-gray your-order-info">Qty: ${giohang.getQuantity()}</span>
                                            </div>
                                            <div>
                                                <c:choose>
                                                    <c:when test="${giohang.getProductEntity().getPromotionPrice() != 0}">
                                                        <h4>${price = giohang.getProductEntity().getPromotionPrice() * giohang.getQuantity()}</h4>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <h4>${price = giohang.getProductEntity().getUnitPrice() * giohang.getQuantity()}</h4>
                                                    </c:otherwise>
                                                </c:choose>
                                            </div>
                                        </div>
                                        <c:set var="total" value="${total + price}"/>
                                    </c:forEach>
                                    <!-- end one item -->
                                </div>
                                <div class="clearfix"></div>
                            </div>
                            <div class="your-order-item">
                                <div class="pull-left"><p class="your-order-f18">Tổng tiền:</p></div>
                                <div class="pull-right"><h5 class="color-black">$ ${total}</h5></div>
                                <div class="clearfix"></div>
                            </div>
                        </div>
                        <div class="your-order-head"><h5>Hình thức thanh toán</h5></div>

                        <div class="your-order-body">
                            <ul class="payment_methods methods">
                                <li class="payment_method_bacs">
                                    <input id="payment_method_bacs" type="radio" class="input-radio" name="payment_method" value="COD" checked="checked" data-order_button_text="">
                                    <label for="payment_method_bacs">Thanh toán khi nhận hàng </label>
                                    <div class="payment_box payment_method_bacs" style="display: block;">
                                        Cửa hàng sẽ gửi hàng đến địa chỉ của bạn, bạn xem hàng rồi thanh toán tiền cho nhân viên giao hàng
                                    </div>
                                </li>

                                <li class="payment_method_cheque">
                                    <input id="payment_method_cheque" type="radio" class="input-radio" name="payment_method" value="ATM" data-order_button_text="">
                                    <label for="payment_method_cheque">Chuyển khoản </label>
                                    <div class="payment_box payment_method_cheque" style="display: none;">
                                        Chuyển tiền đến tài khoản sau:
                                        <br>- Số tài khoản: 123 456 789
                                        <br>- Chủ TK: Nguyễn A
                                        <br>- Ngân hàng ACB, Chi nhánh TPHCM
                                    </div>
                                </li>

                            </ul>
                        </div>
                        <input type="hidden" name="total" value="${total}"/>
                        <div class="text-center"><input type="submit" class="beta-btn primary" value="Đặt hàng"> </div>
                    </div> <!-- .your-order -->
                </div>
            </div>
        </form>

    </div> <!-- #content -->
</div> <!-- .container -->

<%--footer--%>
<c:import url="footer.jsp"/>
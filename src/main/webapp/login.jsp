<form action="login" method="post">
<%@taglib prefix="c" uri=
"jakarta.tags.core"%>
    <h2>Tạo tài khoản mới</h2>
    
    <c:if test="${alert != null}">
        <h3 class="alert alert-danger">${alert}</h3>
    </c:if>
    
    <section>
        <label class="input login-input">
            <div class="input-group">
                <span class="input-group-addon">
                    <i class="fa fa-user"></i>
                </span>
                <input type="text" 
                       placeholder="Tài khoản" 
                       name="username"
                       class="form-control">
            </div>
        </label>
    </section>
</form>

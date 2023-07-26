<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ include file="header.jsp" %>

<div class="slogan container container--90">
    <div class="slogan--item">
        <h1>
            Oddaj rzeczy, których już nie chcesz<br />
            <span class="uppercase">potrzebującym</span>
        </h1>

        <div class="slogan--steps">
            <div class="slogan--steps-title">Wystarczą 4 proste kroki:</div>
            <ul class="slogan--steps-boxes">
                <li>
                    <div><em>1</em><span>Wybierz rzeczy</span></div>
                </li>
                <li>
                    <div><em>2</em><span>Spakuj je w worki</span></div>
                </li>
                <li>
                    <div><em>3</em><span>Wybierz fundację</span></div>
                </li>
                <li>
                    <div><em>4</em><span>Zamów kuriera</span></div>
                </li>
            </ul>
        </div>
    </div>
</div>
</header>

<section class="form--steps">
    <div class="form--steps-instructions">
        <div class="form--steps-container">
            <h3>Ważne!</h3>
            <p data-step="1" class="active">
                Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
                wiedzieć komu najlepiej je przekazać.
            </p>
            <p data-step="2">
                Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
                wiedzieć komu najlepiej je przekazać.
            </p>
            <p data-step="3">
                Wybierz jedną, do
                której trafi Twoja przesyłka.
            </p>
            <p data-step="4">Podaj adres oraz termin odbioru rzeczy.</p>
        </div>
    </div>

    <div class="form--steps-container">
        <div class="form--steps-counter">Krok <span>1</span>/4</div>

        <form:form method="post" modelAttribute="donations">
            <!-- STEP 1: class .active is switching steps -->
            <div data-step="1" class="active">
                <h3>Zaznacz co chcesz oddać:</h3>

                <c:forEach var="category" items="${categories}">
                    <div class="form-group form-group--checkbox">
                        <label>
                            <input type="checkbox" name="categories" id="categories" value="${category.id}" />

                            <span class="checkbox"></span>
                            <span class="description">${category.name}</span>
                        </label>
                    </div>
                </c:forEach>
                <input type="hidden" name="categoryNames" id="categoryNames" value="${category.name}" />

                <div class="form-group form-group--buttons">
                    <button type="button" class="btn next-step">Dalej</button>
                </div>
            </div>

            <!-- STEP 2 -->
            <div data-step="2">
                <h3>Podaj liczbę 60l worków, w które spakowałeś/aś rzeczy:</h3>

                <div class="form-group form-group--inline">
                    <label>
                        Liczba 60l worków:
                        <form:input type="number" path="quantity" step="1" min="1" />
                    </label>
                </div>

                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="button" class="btn next-step">Dalej</button>
                </div>
            </div>


            <!-- STEP 3 -->
            <div data-step="3">
                <h3>Wybierz organizacje, której chcesz pomóc:</h3>
                <c:forEach var="institution" items="${institutions}">
                    <div class="form-group form-group--checkbox">
                        <label>
                            <input type="radio" name="institution" id="institution" value="${institution.id}" />
                            <span class="checkbox radio"></span>
                            <span class="description">
                                <div class="title">${institution.name}</div>
                                <div class="subtitle">${institution.description}</div>
                            </span>
                        </label>
                    </div>
                </c:forEach>
                <input type="hidden" name="institutionName" id="institutionName" value="${institution.name}" />

                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="button" class="btn next-step">Dalej</button>
                </div>
            </div>

            <!-- STEP 4 -->
            <div data-step="4">
                <h3>Podaj adres oraz termin odbioru rzeczy przez kuriera:</h3>

                <div class="form-section form-section--columns">
                    <div class="form-section--column">
                        <h4>Adres odbioru</h4>
                        <div class="form-group form-group--inline">
                            <label> Ulica <form:input type="text"
                                                      path="street"
                                                      placeholder="Ulica i numer domu"
                                                      pattern="^[A-Za-z]{2}[A-Za-z0-9 -]*$"
                                                      title="Podaj ulicę i numer domu"/>
                            </label>
                        </div>

                        <div class="form-group form-group--inline">
                            <label> Miasto <form:input type="text" path="city"
                                                       placeholder="Miasto"
                                                       pattern="^[A-Za-z]{2}[A-Za-z -]*$"
                                                       title="Podaj nazwę miasta"/> </label>
                        </div>

                        <div class="form-group form-group--inline">
                            <label>
                                Kod pocztowy <form:input type="text"
                                                         path="zipCode"
                                                         placeholder="Kod pocztowy"
                                                         pattern="\d{2}-\d{3}"
                                                         title="Podaj kod pocztowy"
                            />
                            </label>
                        </div>

                        <div class="form-group form-group--inline">
                            <label>
                                Numer telefonu <form:input type="phone"
                                                           path="phone"
                                                           placeholder="Numer telefonu"
                                                           pattern="^(?:(?:\+?48)?(?:\s|-)?(?:\(?\d{2,3}\)?(?:\s|-)?)?)?(?:(?:\d{3})(?:\s|-)?(?:\d{2})(?:\s|-)?(?:\d{2})|(?:\d{2})(?:\s|-)?(?:\d{3})(?:\s|-)?(?:\d{2})|(?:\d{2})(?:\s|-)?(?:\d{2})(?:\s|-)?(?:\d{3}))$"
                                                           title="Wprowadź numer telefonu z lub bez kierunkowego '48'"/>
                            </label>
                        </div>
                    </div>

                    <div class="form-section--column">
                        <h4>Termin odbioru</h4>
                        <div class="form-group form-group--inline">
                            <label> Data <form:input type="date"
                                                     path="pickUpDate"
                                                     placeholder="[yyyy-MM-dd]"
                                                     pattern="\d{4}-\d{2}-\d{2}"
                                                     title="Wprowadź datę w formacie yyyy-MM-DD"/>
                            </label>
                        </div>

                        <div class="form-group form-group--inline">
                            <label> Godzina <form:input type="time"
                                                        path="pickUpTime"
                                                        placeholder="[hh:mm]"
                                                        pattern="\d{2}:\d{2}"
                                                        title="Wprowadź czas w formacie hh:mm"/>
                            </label>
                        </div>

                        <div class="form-group form-group--inline">
                            <label>
                                Uwagi dla kuriera
                                <form:textarea path="pickUpComment" rows="5"
                                               placeholder="Jeśli chcesz, możesz wprowadzić komentarz."
                                               title="Pole nieobowiązkowe"/>
                            </label>
                        </div>
                    </div>
                </div>
                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="button" class="btn next-step">Dalej</button>
                </div>
            </div>

            <!-- STEP 5 -->
            <div data-step="5">
                <h3>Podsumowanie Twojej darowizny</h3>

                <div class="summary">

                        <%--                    Here will appear summary section, generated with Java Script--%>

                </div>

                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <sec:csrfInput/>
                    <button type="submit" class="btn">Potwierdzam</button>
                </div>
            </div>

        </form:form>

    </div>
</section>

<%@ include file="footer.jsp" %>

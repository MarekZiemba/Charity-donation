document.addEventListener("DOMContentLoaded", function() {

  /**
   * Form Select
   */
  class FormSelect {
    constructor($el) {
      this.$el = $el;
      this.options = [...$el.children];
      this.init();
    }

    init() {
      this.createElements();
      this.addEvents();
      this.$el.parentElement.removeChild(this.$el);
    }

    createElements() {
      // Input for value
      this.valueInput = document.createElement("input");
      this.valueInput.type = "text";
      this.valueInput.name = this.$el.name;

      // Dropdown container
      this.dropdown = document.createElement("div");
      this.dropdown.classList.add("dropdown");

      // List container
      this.ul = document.createElement("ul");

      // All list options
      this.options.forEach((el, i) => {
        const li = document.createElement("li");
        li.dataset.value = el.value;
        li.innerText = el.innerText;

        if (i === 0) {
          // First clickable option
          this.current = document.createElement("div");
          this.current.innerText = el.innerText;
          this.dropdown.appendChild(this.current);
          this.valueInput.value = el.value;
          li.classList.add("selected");
        }

        this.ul.appendChild(li);
      });

      this.dropdown.appendChild(this.ul);
      this.dropdown.appendChild(this.valueInput);
      this.$el.parentElement.appendChild(this.dropdown);
    }

    addEvents() {
      this.dropdown.addEventListener("click", e => {
        const target = e.target;
        this.dropdown.classList.toggle("selecting");

        // Save new value only when clicked on li
        if (target.tagName === "LI") {
          this.valueInput.value = target.dataset.value;
          this.current.innerText = target.innerText;
        }
      });
    }
  }
  document.querySelectorAll(".form-group--dropdown select").forEach(el => {
    new FormSelect(el);
  });

  /**
   * Hide elements when clicked on document
   */
  document.addEventListener("click", function(e) {
    const target = e.target;
    const tagName = target.tagName;

    if (target.classList.contains("dropdown")) return false;

    if (tagName === "LI" && target.parentElement.parentElement.classList.contains("dropdown")) {
      return false;
    }

    if (tagName === "DIV" && target.parentElement.classList.contains("dropdown")) {
      return false;
    }

    document.querySelectorAll(".form-group--dropdown .dropdown").forEach(el => {
      el.classList.remove("selecting");
    });
  });

  /**
   * Switching between form steps
   */
  class FormSteps {
    constructor(form) {
      this.$form = form;
      this.$next = form.querySelectorAll(".next-step");
      this.$prev = form.querySelectorAll(".prev-step");
      this.$step = form.querySelector(".form--steps-counter span");
      this.currentStep = 1;

      this.$stepInstructions = form.querySelectorAll(".form--steps-instructions p");
      const $stepForms = form.querySelectorAll("form > div");
      this.slides = [...this.$stepInstructions, ...$stepForms];

      this.init();
    }

    /**
     * Init all methods
     */
    init() {
      this.events();
      this.updateForm();
    }

    /**
     * All events that are happening in form
     */
    events() {
      // Next step
      this.$next.forEach(btn => {
        btn.addEventListener("click", e => {
          e.preventDefault();
          this.currentStep++;
          this.updateForm();
        });
      });

      // Previous step
      this.$prev.forEach(btn => {
        btn.addEventListener("click", e => {
          e.preventDefault();
          this.currentStep--;
          this.updateForm();
        });
      });

      // Form submit
      this.$form.querySelector("form").addEventListener("submit", e => this.submit(e));
    }

    /**
     * Update form front-end
     * Show next or previous section etc.
     */
    updateForm() {
      this.$step.innerText = this.currentStep;

      // TODO: Validation

      this.slides.forEach(slide => {
        slide.classList.remove("active");

        if (slide.dataset.step == this.currentStep) {
          slide.classList.add("active");
        }
      });

      this.$stepInstructions[0].parentElement.parentElement.hidden = this.currentStep >= 5;
      this.$step.parentElement.hidden = this.currentStep >= 5;

      // TODO: get data from inputs and show them in summary

      // Wyświetl podsumowanie w elemencie <div class="summary">
      if (this.currentStep === 5) {
        const formData = this.gatherFormData();
        const summaryElement = document.querySelector(".summary");

      // wyświetlenie danych w podsumowaniu
        summaryElement.innerHTML = `
        <div class="form-section">
            <h4>Oddajesz:</h4>
            <ul>
                <li>
                    <span class="icon icon-bag"></span>
                    <span class="summary--text">Worki: ${formData.quantity} w tym: ${formData.categories.join(", ")}</span>
                </li>
                <li>
                    <span class="icon icon-hand"></span>
                    <span class="summary--text">Dla ${formData.institution}</span>
                </li>
            </ul>
        </div>
        <div class="form-section form-section--columns">
            <div class="form-section--column">
                <h4>Adres odbioru:</h4>
                <ul>
                    <li>${formData.street}</li>
                    <li>${formData.city}</li>
                    <li>${formData.zipCode}</li>
                    <li>${formData.phone}</li>
                </ul>
            </div>

            <div class="form-section--column">
                <h4>Termin odbioru:</h4>
                <ul>
                    <li>${formData.pickUpDate}</li>
                    <li>${formData.pickUpTime}</li>
                    <li>${formData.pickUpComment}</li>
                </ul>
            </div>
        </div>
    `;
      }
    }

    gatherFormData() {
      const formData = {};
      const form = this.$form.querySelector("form");

      // Pobierz dane z kroków formularza i zapisz w obiekcie formData
      formData.quantity = form.querySelector('input[name="quantity"]').value;
      formData.street = form.querySelector('input[name="street"]').value;
      formData.city = form.querySelector('input[name="city"]').value;
      formData.zipCode = form.querySelector('input[name="zipCode"]').value;
      formData.phone = form.querySelector('input[name="phone"]').value;

      // Pobierz dane z wybranej daty i czasu odbioru
      formData.pickUpDate = form.querySelector('input[name="pickUpDate"]').value;
      formData.pickUpTime = form.querySelector('input[name="pickUpTime"]').value;

      // Pobierz dane z komentarza
      formData.pickUpComment = form.querySelector('textarea[name="pickUpComment"]').value;

      // Pobierz dane z wybranych kategorii (nazwy)
      formData.categories = [];
      form.querySelectorAll('input[name="categories"]:checked').forEach(checkbox => {
        formData.categories.push(checkbox.parentElement.querySelector('.description').innerText.trim());
      });

      // Pobierz dane z wybranej instytucji (nazwa)
      formData.institution = form.querySelector('input[name="institution"]:checked').parentElement.querySelector('.title').innerText.trim();
      return formData;
    }

  }
  const form = document.querySelector(".form--steps");
  if (form !== null) {
    new FormSteps(form);
  }
});
// === Script general del sitio Ónix Spa ===

// === Script general del sitio Ónix Spa ===

document.addEventListener("DOMContentLoaded", () => {
  console.log("Sitio Ónix Spa cargado correctamente.");

  // Detectar en qué página estamos
  const path = window.location.pathname;
  if (path.includes("productos")) {
    console.log("Página actual: Productos");
  } else if (path.includes("servicios")) {
    console.log("Página actual: Servicios");
  } else if (path.includes("reservas")) {
    console.log("Página actual: Reservas");
  } else {
    console.log("Página actual: Inicio");
  }

  // Scroll suave hacia arriba
  const scrollTopButton = document.getElementById("btnScrollTop");
  if (scrollTopButton) {
    scrollTopButton.addEventListener("click", () =>
      window.scrollTo({ top: 0, behavior: "smooth" })
    );
  }

  // Reservas - ejemplo de acción
  const reservarBtn = document.querySelector(".bg-primary.text-lg");
  if (reservarBtn) {
    reservarBtn.addEventListener("click", () => {
      alert("✅ Cita reservada con éxito (demo). Próximamente conexión con MySQL.");
    });
  }
});

document.addEventListener("DOMContentLoaded", function () {
  function applyTargetBlankToApiLinks() {
    var links = document.querySelectorAll('a[href*="/api/"], a[href^="api/"]');
    links.forEach(function (link) {
      link.setAttribute("target", "_blank");
      link.setAttribute("rel", "noopener noreferrer");
    });
  }

  applyTargetBlankToApiLinks();

  if (typeof document$ !== "undefined" && typeof document$.subscribe === "function") {
    document$.subscribe(applyTargetBlankToApiLinks);
  }
});

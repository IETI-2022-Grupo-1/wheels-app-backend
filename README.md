# Dev 
## Consideraciones
* Una vez termine sus desarrollos suba su rama a github siguiendo las convenciones acordadas (la rama debe tener su nombre).
* Cuando su rama se encuentre en el repositorio remoto, abra un _pull request_ a dev.
  * Este _pull request_ debe ser aprobado por al menos dos personas para ser mergeado.
* Una vez se tenga estable la rama _dev_, se hará un PR de _dev_ a _master_.
  * Este PR debe tener la aprobación de todo el equipo.
  * Este será el código que se subirá al servidor.
## Por favor leer esto
* Esta es la estructura sugerida de paquetes.
* Me parece un poco más limpio que dentro del paquete "services" en lugar de tener clases regadas y luego un paquete "impl" tengamos dentro del paquete adecuado tanto la intefaz como su implementación.
* Cada uno debe generar una rama con su nombre
* El primer commit de su rama debe ser el título de la historia de usuario y la url
  * Registro de usuarios (C-R-U-D) - https://tree.taiga.io/project/juancho20sp-wheelsapp/us/1?no-milestone=1 
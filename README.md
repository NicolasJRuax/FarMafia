https://github.com/NicolasJRuax/FarMafia.git

# Farmafia

# Farmacias Zaragoza

Esta aplicación muestra una lista de farmacias ubicadas en Zaragoza utilizando datos proporcionados en un archivo JSON. El objetivo principal es permitir al usuario visualizar el nombre y el teléfono de las farmacias en una lista y, al seleccionar una farmacia, abrir su ubicación en un mapa interactivo.

---

## **Características principales**
1. **Lista de farmacias**:
   - Muestra el nombre y el número de teléfono de las farmacias.
   - Cada elemento de la lista incluye un ícono de farmacia para mejorar la experiencia visual.
   
2. **Ubicación en el mapa**:
   - Al seleccionar una farmacia, la aplicación muestra su ubicación en OpenStreetMap en un `WebView`.

3. **Datos locales**:
   - La información de las farmacias se carga desde un archivo JSON localizado en los assets de la aplicación.

---

## **Estructura del proyecto**

### 1. **Clases principales**
#### **`MainActivity`**
- **Función**: Carga y muestra la lista de farmacias en un `RecyclerView`.
- **Detalles importantes**:
  - Lee el archivo `pharmacies.json` desde los assets y lo convierte en una lista de objetos `Pharmacy`.
  - Configura un `RecyclerView` con un adaptador personalizado (`PharmacyAdapter`) para mostrar la lista.
  - Maneja la navegación hacia `PharmacyDetailActivity` al hacer clic en una farmacia.

#### **`PharmacyDetailActivity`**
- **Función**: Muestra la ubicación de una farmacia seleccionada en un mapa interactivo de OpenStreetMap.
- **Detalles importantes**:
  - Obtiene los datos de la farmacia seleccionada (nombre, latitud y longitud) a través de un `Intent`.
  - Utiliza un `WebView` para cargar la URL correspondiente a la ubicación en OpenStreetMap.
  - Configura el `WebView` para que soporte JavaScript y evite abrir enlaces en el navegador externo.

#### **`Pharmacy`**
- **Función**: Modelo de datos para representar la información de cada farmacia.
- **Atributos**:
  - `name`: Nombre de la farmacia.
  - `phone`: Número de teléfono.
  - `latitude`: Latitud de la ubicación.
  - `longitude`: Longitud de la ubicación.
- **Métodos**: Proporciona métodos para acceder a los datos (`getName()`, `getPhone()`, etc.).

#### **`PharmacyAdapter`**
- **Función**: Adaptador personalizado para vincular los datos de las farmacias con el `RecyclerView`.
- **Detalles importantes**:
  - Infla el diseño del elemento individual de la lista (`item_pharmacy.xml`).
  - Configura los datos de cada farmacia (nombre y teléfono) en los correspondientes `TextView`.
  - Maneja los clics en los elementos para navegar a `PharmacyDetailActivity`.

---

### 2. **Layouts**
#### **`activity_main.xml`**
- Define la interfaz principal con un `RecyclerView` para mostrar la lista de farmacias.

#### **`activity_pharmacy_detail.xml`**
- Contiene un `WebView` que muestra el mapa interactivo de OpenStreetMap con la ubicación de la farmacia seleccionada.

#### **`item_pharmacy.xml`**
- Diseña cada elemento de la lista de farmacias:
  - Incluye un `ImageView` con un ícono de farmacia.
  - Muestra el nombre y teléfono en dos `TextView`.

---

### 3. **Archivo JSON**
El archivo `pharmacies.json` contiene la información de las farmacias en formato JSON. Cada farmacia tiene los siguientes atributos:
- `name`: Nombre de la farmacia.
- `phone`: Número de teléfono.
- `latitude`: Latitud de la ubicación.
- `longitude`: Longitud de la ubicación.


---

## 4. Cómo funciona la aplicación

### Inicio
- Al abrir la aplicación, `MainActivity` carga los datos de las farmacias desde el archivo JSON.
- Los datos se muestran en un `RecyclerView` utilizando el diseño definido en `item_pharmacy.xml`.

### Selección de farmacia
- Al hacer clic en una farmacia, se abre `PharmacyDetailActivity`.
- Los datos de la farmacia seleccionada (nombre, latitud, longitud) se pasan a través de un `Intent`.

### Visualización en mapa
- `PharmacyDetailActivity` utiliza un `WebView` para cargar la ubicación de la farmacia en OpenStreetMap.

---

## Cómo agregar más farmacias

1. Edita el archivo `pharmacies.json` en la carpeta `assets` y añade nuevas entradas con el siguiente formato:

```json
{
  "name": "Farmacia Ejemplo",
  "phone": "123456789",
  "latitude": 41.123456,
  "longitude": -0.123456
}

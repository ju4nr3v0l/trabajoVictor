# Sistema de Gestión de Información de Clínica

## 📋 Descripción General

Sistema de gestión de información para clínicas que facilita el manejo eficiente de datos de pacientes y personal médico. Implementado siguiendo los principios de **Arquitectura Hexagonal (Ports and Adapters)** para garantizar separación de responsabilidades, alta testabilidad y bajo acoplamiento.

## 🏗️ Arquitectura Hexagonal

### Principios Implementados

- **Separación del Dominio**: Lógica de negocio independiente de detalles técnicos
- **Alta Testabilidad**: Dominio testeable sin dependencias externas
- **Bajo Acoplamiento**: Cambios en infraestructura no afectan el dominio
- **Independencia de Frameworks**: Fácil intercambio de tecnologías

### Estructura de Capas

```
src/
├── domain/                    # 🧠 NÚCLEO DEL DOMINIO
│   ├── model/                 # Entidades de negocio
│   │   ├── Usuario.java
│   │   ├── Paciente.java
│   │   ├── ContactoEmergencia.java
│   │   ├── SeguroMedico.java
│   │   └── Rol.java
│   ├── ports/                 # 🔌 PUERTOS (Interfaces)
│   │   ├── UsuarioRepository.java
│   │   └── PacienteRepository.java
│   └── usecases/              # Casos de uso
│       ├── GestionarUsuarios.java
│       └── GestionarPacientes.java
├── infrastructure/            # 🔧 ADAPTADORES
│   └── adapters/
│       ├── UsuarioRepositoryMemoria.java
│       └── PacienteRepositoryMemoria.java
├── application/               # 🎮 CONTROLADORES
│   └── ClinicaController.java
└── Main.java                  # Punto de entrada
```

## 👥 Roles del Sistema

### 1. Recursos Humanos
- **Permisos**: Crear y eliminar usuarios
- **Restricciones**: No puede ver información de pacientes, medicamentos ni procedimientos

### 2. Personal Administrativo
- **Permisos**: Registrar pacientes, programar citas, gestionar facturación
- **Funciones**: Manejo de información básica de pacientes y seguros médicos

### 3. Soporte de Información
- **Permisos**: Mantener inventarios de medicamentos y procedimientos
- **Funciones**: Integridad de datos y soporte técnico

### 4. Enfermeras
- **Permisos**: Registrar signos vitales y medicamentos administrados
- **Funciones**: Gestión de visitas y procedimientos

### 5. Médicos
- **Permisos**: Acceso completo a información de pacientes
- **Funciones**: Crear y actualizar historias clínicas

## 🏛️ Componentes de la Arquitectura

### Dominio (Core)

#### Entidades Principales

**Usuario**
```java
public class Usuario {
    private final String cedula;           // 1-10 dígitos
    private final String nombreCompleto;
    private final String fechaNacimiento;  // DD/MM/YYYY, máx 150 años
    private final String direccion;        // Máx 30 caracteres
    private final Rol rol;
    private final String telefono;
    private final String correo;           // Validación @ y dominio
    private final String nombreUsuario;    // Único, máx 15 chars, alfanumérico
    private final String contrasena;       // Mayúscula + número + especial + 8 chars
}
```

**Paciente**
```java
public class Paciente {
    private final String cedula;
    private final String nombreCompleto;
    private final String fechaNacimiento;
    private final String genero;           // Masculino, Femenino, Otro
    private final String direccion;
    private final String telefono;         // 10 dígitos
    private final String correo;
    private final ContactoEmergencia contactoEmergencia;
    private final SeguroMedico seguroMedico;
}
```

#### Casos de Uso

**GestionarUsuarios**
- Validación de permisos por rol
- Verificación de unicidad de nombre de usuario
- Aplicación de reglas de negocio para creación/eliminación

**GestionarPacientes**
- Registro exclusivo por Personal Administrativo
- Validación de datos según especificaciones
- Gestión de contactos de emergencia y seguros médicos

### Puertos (Interfaces)

```java
public interface UsuarioRepository {
    void guardar(Usuario usuario);
    Optional<Usuario> buscarPorCedula(String cedula);
    Optional<Usuario> buscarPorNombreUsuario(String nombreUsuario);
    void eliminar(String cedula);
    boolean existeNombreUsuario(String nombreUsuario);
}
```

### Adaptadores (Implementaciones)

**UsuarioRepositoryMemoria**
- Implementación en memoria usando HashMap
- Fácil intercambio por base de datos real
- Mantiene integridad referencial

## 🔒 Validaciones Implementadas

### Usuario
- **Cédula**: 1-10 dígitos
- **Correo**: Formato válido con @ y dominio
- **Nombre Usuario**: Único, máximo 15 caracteres, solo letras y números
- **Contraseña**: Mínimo 8 caracteres, incluye mayúscula, número y carácter especial

### Paciente
- **Teléfono**: Exactamente 10 dígitos
- **Fecha Nacimiento**: Máximo 150 años
- **Contacto Emergencia**: Teléfono de 10 dígitos

### Permisos por Rol
- **Recursos Humanos**: Solo puede crear/eliminar usuarios
- **Personal Administrativo**: Solo puede registrar pacientes
- Validación automática en casos de uso

## 🚀 Funcionamiento del Sistema

### Flujo de Creación de Usuario

```java
// 1. Solicitud llega al controlador
controller.crearUsuario(datos..., rolSolicitante);

// 2. Controlador delega al caso de uso
gestionarUsuarios.crearUsuario(datos..., rolSolicitante);

// 3. Caso de uso valida permisos
if (rolSolicitante != Rol.RECURSOS_HUMANOS) {
    throw new IllegalArgumentException("Solo Recursos Humanos puede crear usuarios");
}

// 4. Valida unicidad
if (usuarioRepository.existeNombreUsuario(nombreUsuario)) {
    throw new IllegalArgumentException("Nombre de usuario ya existe");
}

// 5. Crea entidad (con validaciones internas)
Usuario usuario = new Usuario(datos...);

// 6. Persiste a través del puerto
usuarioRepository.guardar(usuario);
```

### Flujo de Registro de Paciente

```java
// Similar al anterior pero con validación de rol Personal Administrativo
if (rolSolicitante != Rol.PERSONAL_ADMINISTRATIVO) {
    throw new IllegalArgumentException("Solo Personal Administrativo puede registrar pacientes");
}
```

## 🧪 Demostración del Sistema

El `Main.java` incluye una demostración completa:

1. **Configuración de Arquitectura**: Inyección de dependencias manual
2. **Creación de Usuario RH**: Exitosa
3. **Creación de Usuario Administrativo**: Exitosa (por RH)
4. **Registro de Paciente**: Exitoso (por Personal Administrativo)
5. **Intento de Creación sin Permisos**: Falla controlada

```bash
=== Sistema de Gestión de Clínica ===

1. Creando usuario de Recursos Humanos...
Usuario creado exitosamente

2. Creando usuario Personal Administrativo...
Usuario creado exitosamente

3. Registrando paciente...
Paciente registrado exitosamente

4. Intentando crear usuario sin permisos...
Error: Solo Recursos Humanos puede crear usuarios
```

## 🔄 Beneficios de la Arquitectura

### Testabilidad
```java
// Test unitario del dominio sin dependencias externas
@Test
void deberiaCrearUsuarioConDatosValidos() {
    UsuarioRepository mockRepo = mock(UsuarioRepository.class);
    GestionarUsuarios useCase = new GestionarUsuarios(mockRepo);
    
    useCase.crearUsuario(datos..., Rol.RECURSOS_HUMANOS);
    
    verify(mockRepo).guardar(any(Usuario.class));
}
```

### Intercambiabilidad
```java
// Fácil cambio de implementación
UsuarioRepository repo = new UsuarioRepositoryBD(); // En lugar de Memoria
GestionarUsuarios useCase = new GestionarUsuarios(repo);
```

### Mantenibilidad
- Cambios en UI no afectan lógica de negocio
- Cambios en BD no afectan casos de uso
- Reglas de negocio centralizadas en el dominio

## 🚀 Ejecución

```bash
# Compilar
cd src
javac -d ../out $(find . -name "*.java")

# Ejecutar
cd ../out
java Main
```

## 🔮 Extensibilidad

El sistema está preparado para:
- **Nuevos Adaptadores**: Base de datos, APIs REST, etc.
- **Nuevos Casos de Uso**: Historia clínica, facturación, inventarios
- **Nuevas Validaciones**: Sin modificar estructura existente
- **Nuevos Roles**: Agregando al enum y casos de uso correspondientes

La arquitectura hexagonal garantiza que estas extensiones no rompan el código existente y mantengan la separación de responsabilidades.

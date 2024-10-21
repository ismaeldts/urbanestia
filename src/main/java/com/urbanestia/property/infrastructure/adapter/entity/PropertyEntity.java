package com.urbanestia.property.infrastructure.adapter.entity;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document("properties")
public class PropertyEntity {

    @Id
    private String id;
    private String ownerId;
    private String title;
    private String description;
    private String postalCode;
    private Integer guestCapacity;
    private Integer numberOfRooms;
    private Integer numberOfBathrooms;
    private Double price;
    private String imgUrl;
    private String status; // Estado de la publicación: Borrador, Publicado, Pausado, Vendido, Alquilado, etc.
    private String direction; // Dirección de la propiedad
    private List<String> descriptionImages;
    private LocalDateTime publicationDate;
    private Double latitude;
    private Double longitude;
    private Double sizeInSquareMeters;
    private String condition;
    private String cityId;
    private String address; // Dirección de la propiedad
    private String propose; // Propósito de la propiedad: Venta, Arriendo, etc.
    private Boolean acceptsBarter; // Acepta permuta (trueque)
    private Date yearsOld; // Fecha aproximada de construcción (antigüedad)
    private String parking; // Información de parqueadero (boolean o string dependiendo de la lógica de tu aplicación)
    private String propertyType; // Tipo de inmueble: Casa, Apartamento, etc.
    private List<String> amenities; // Lista de comodidades o extras que ofrece la propiedad
    private Boolean acceptsVisits; // Acepta visitas (booleano)
    private Integer stratum; // Estrato
    private String uniquePropertyCode; // Código Único de Propiedad (CUP) para buscar la propiedad en la aplicación


}

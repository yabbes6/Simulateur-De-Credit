package org.example.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditModel {
    private double montant;
    private int duree;
    private double taux;
    private double mensualite;
}

package com.sistema.pagos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistema.pagos.entities.Pago;
import com.sistema.pagos.enums.PagoStatus;
import com.sistema.pagos.enums.TypePago;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Long> {

    List<Pago> findByEstudianteCodigo(String codigo);

    List<Pago> findByStatus(PagoStatus status);

    List<Pago> findByType(TypePago typePago);

}
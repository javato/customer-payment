package org.jroldan.customerpayment.service.commons;

import org.jroldan.customerpayment.exception.CustomerPaymentException;

import java.io.Serializable;
import java.util.List;

public interface CrudServiceCustom<T, ID> extends Serializable {
    T findById(ID id) throws CustomerPaymentException;

    List<T> findAll() throws CustomerPaymentException;

    boolean exists(T entity) throws CustomerPaymentException;

    boolean existsById(ID id) throws CustomerPaymentException;

    T saveOrUpdate(T entity) throws CustomerPaymentException;

    void validate(T entity) throws CustomerPaymentException;

    void delete(T entity) throws CustomerPaymentException;

    void deleteById(ID id) throws CustomerPaymentException;
}

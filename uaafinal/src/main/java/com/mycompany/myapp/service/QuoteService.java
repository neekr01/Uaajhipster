package com.mycompany.myapp.service;

import com.mycompany.myapp.service.dto.QuoteDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link com.mycompany.myapp.domain.Quote}.
 */
public interface QuoteService {

    /**
     * Save a quote.
     *
     * @param quoteDTO the entity to save.
     * @return the persisted entity.
     */
    QuoteDTO save(QuoteDTO quoteDTO);

    /**
     * Get all the quotes.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<QuoteDTO> findAll(Pageable pageable);


    /**
     * Get the "id" quote.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<QuoteDTO> findOne(String id);

    /**
     * Delete the "id" quote.
     *
     * @param id the id of the entity.
     */
    void delete(String id);
}

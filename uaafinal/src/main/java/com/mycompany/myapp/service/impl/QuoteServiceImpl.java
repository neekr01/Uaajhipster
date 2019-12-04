package com.mycompany.myapp.service.impl;

import com.mycompany.myapp.service.QuoteService;
import com.mycompany.myapp.domain.Quote;
import com.mycompany.myapp.repository.QuoteRepository;
import com.mycompany.myapp.service.dto.QuoteDTO;
import com.mycompany.myapp.service.mapper.QuoteMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Quote}.
 */
@Service
public class QuoteServiceImpl implements QuoteService {

    private final Logger log = LoggerFactory.getLogger(QuoteServiceImpl.class);

    private final QuoteRepository quoteRepository;

    private final QuoteMapper quoteMapper;

    public QuoteServiceImpl(QuoteRepository quoteRepository, QuoteMapper quoteMapper) {
        this.quoteRepository = quoteRepository;
        this.quoteMapper = quoteMapper;
    }

    /**
     * Save a quote.
     *
     * @param quoteDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public QuoteDTO save(QuoteDTO quoteDTO) {
        log.debug("Request to save Quote : {}", quoteDTO);
        Quote quote = quoteMapper.toEntity(quoteDTO);
        quote = quoteRepository.save(quote);
        return quoteMapper.toDto(quote);
    }

    /**
     * Get all the quotes.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    public Page<QuoteDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Quotes");
        return quoteRepository.findAll(pageable)
            .map(quoteMapper::toDto);
    }


    /**
     * Get one quote by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    public Optional<QuoteDTO> findOne(String id) {
        log.debug("Request to get Quote : {}", id);
        return quoteRepository.findById(id)
            .map(quoteMapper::toDto);
    }

    /**
     * Delete the quote by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(String id) {
        log.debug("Request to delete Quote : {}", id);
        quoteRepository.deleteById(id);
    }
}

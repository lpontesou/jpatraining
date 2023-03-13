package br.com.ntt.jpa.model.services.populator;

public interface Populator<SOURCE,TARGET>{

    void populate(SOURCE source,TARGET target);
}

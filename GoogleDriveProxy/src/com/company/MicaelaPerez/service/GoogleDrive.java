package com.company.MicaelaPerez.service;

import com.company.MicaelaPerez.models.DriveDocument;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class GoogleDrive implements IAccesDocument{
    protected List<DriveDocument> documents = new ArrayList<>();

    public List<DriveDocument> findDocument(String url){
        return documents.stream()
                .filter(doc -> doc.getUrl().equals(url))
                .collect(Collectors.toList());
    }

    @Override
    public String accessDocument(String url, String email) {
        List<DriveDocument> foundDocumentList = findDocument(url);
        Boolean isAuthorized = foundDocumentList.get(0).isUserAuthorized(email);
        if(!foundDocumentList.isEmpty() && isAuthorized) {
            return "acceso autorizado";
        }
        return "acceso denegado";
    }

    public void addDocument(DriveDocument document){
        documents.add(document);
    }

}

package com.VisaPassport.entities;

import com.VisaPassport.metier.Pagination;

public class Pagination_v1 implements Pagination {

	@Override
	public int[] getPaginationPages(int[] pages, int pas, int numPage) {
		int debut;
		int fin;
		int i;
		int tab[] = new int[pas];
		
		if (pages.length > pas) {
			debut = (numPage + pas - 1) >= pages.length ? numPage - pas + (pages.length - numPage) : numPage;
			fin = (debut + pas - 1) >= pages.length - 1 ? pages.length - 1 : debut + pas - 1;
			for (i = 0; i < pas; i++) {
				tab[i] = debut;
				if (debut < fin) {
					debut++;
				}
			}
		} else {
			return pages;
		}
		
		return tab;
	}
	
}

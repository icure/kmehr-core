package org.taktik.icure.asynclogic.be.inami.importer

import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.persistentMapOf

object Refs {
	val refs = mapOf(

		"a_partir_du_75eme_anniversaire_avec_dmg_et_malade_chronique_avec_dmg_sans_regime_preferentiel" to "old_no_preferentialstatus_dmg,dmg_no_preferentialstatus_chronical",
		"_" to "any",
		"_prix_sur_facture" to "any",
		"" to "any",
		"a_l_acte" to "any",
		"base_de_remboursement" to "any",
		"montant_fixe_mensuel_pour_les_maisons_medicales" to "any",
		"forfait_partiel_125_code_prestation_relative_0081255_pour_seances_jusque_et_y_compris_la_capacite_normale_de_facturation_0051251_pour_seances_depassant_la_capacite_normale_de_facturation" to "any",
		"forfait_partiel_133_code_prestation_relative_0081336_pour_seances_jusque_et_y_compris_la_capacite_normale_de_facturation_0051332_pour_seances_depassant_la_capacite_normale_de_facturation" to "any",
		"forfait_partiel_150_code_prestation_relative_0081502_pour_seances_jusque_et_y_compris_la_capacite_normale_de_facturation_0051505_pour_seances_depassant_la_capacite_normale_de_facturation" to "any",
		"forfait_partiel_166_code_prestation_relative_0081664_pour_seances_jusque_et_y_compris_la_capacite_normale_de_facturation_0051660_pour_seances_depassant_la_capacite_normale_de_facturation" to "any",
		"forfait_partiel_175_code_prestation_relative_0081756_pour_seances_jusque_et_y_compris_la_capacite_normale_de_facturation_0051752_pour_seances_depassant_la_capacite_normale_de_facturation" to "any",
		"forfait_partiel_200_code_prestation_relative_0082003_pour_seances_jusque_et_y_compris_la_capacite_normale_de_facturation_0052006_pour_seances_depassant_la_capacite_normale_de_facturation" to "any",
		"forfait_partiel_25_code_prestation_relative_0080253_pour_seances_jusque_et_y_compris_la_capacite_normale_de_facturation_0050256_pour_seances_depassant_la_capacite_normale_de_facturation" to "any",
		"forfait_partiel_33_code_prestation_relative_0080334_pour_seances_jusque_et_y_compris_la_capacite_normale_de_facturation_0050330_pour_seances_depassant_la_capacite_normale_de_facturation" to "any",
		"forfait_partiel_50_code_prestation_relative_0080500_pour_seances_jusque_et_y_compris_la_capacite_normale_de_facturation_0050503_pour_seances_depassant_la_capacite_normale_de_facturation" to "any",
		"forfait_partiel_66_code_prestation_relative_0080662_pour_seances_jusque_et_y_compris_la_capacite_normale_de_facturation_0050665_pour_seances_depassant_la_capacite_normale_de_facturation" to "any",
		"forfait_partiel_75_code_prestation_relative_0080754_pour_seances_jusque_et_y_compris_la_capacite_normale_de_facturation_0050750_pour_seances_depassant_la_capacite_normale_de_facturation" to "any",
		"maximale" to "any",
		"prix" to "any",
		"seulement_les_centres_agrees_pour_groupe_cible_15_peuvent_facturer_ce_numero_de_code" to "any",
		"seulement_les_centres_agrees_pour_groupe_cible_16_peuvent_facturer_ce_numero_de_code" to "any",
		"seulement_les_centres_agrees_pour_groupe_cible_17_peuvent_facturer_ce_numero_de_code" to "any",
		"seulement_les_centres_agrees_pour_groupe_cible_18_peuvent_facturer_ce_numero_de_code" to "any",
		"seulement_les_centres_agrees_pour_groupe_cible_19_peuvent_facturer_ce_numero_de_code" to "any",
		"seulement_les_centres_agrees_pour_groupe_cible_1bis_peuvent_facturer_ce_numero_de_code" to "any",
		"voir_liste_9_53_et_9_65_centres_annexe_du_circulaire_aux_organismes_assureurs_" to "any",
		"de_10_a_75_ans_avec_dmg_a_partir_du_75eme_anniversaire_sans_dmg_malade_chronique_sans_dmg_medecin_stagiaire_avec_regime_preferentiel" to "trainee_preferentialstatus_regular_dmg_preferentialstatus,trainee_preferentialstatus_old_no_dmg_preferentialstatus,trainee_preferentialstatus_chronical_no_dmg_preferentialstatus",
		"a_partir_du_75eme_anniversaire_avec_dmg_et_malade_chronique_avec_dmg_medecin_stagiaire_une_des_conditions_de_surveillance_de_stage_non_rempli_avec_regime_preferentiel" to "trainee_old_dmg_preferentialstatus,trainee_chronical_dmg_referentialstatus",
		"de_10_a_75_ans_avec_dmg_a_partir_du_75eme_anniversaire_sans_dmg_malade_chronique_sans_dmg_medecin_stagiaire_sans_regime_preferentiel" to "trainee_no_preferentialstatus_regular_dmg,trainee_no_preferentialstatus_old_no_dmg,trainee_no_preferentialstatus_chronical_no_dmg",
		"a_partir_du_75eme_anniversaire_avec_dmg_et_malade_chronique_avec_dmg_medecin_stagiaire_une_des_conditions_de_surveillance_de_stage_non_rempli_sans_regime_preferentiel" to "trainee_no_preferentialstatus_old_dmg,trainee_no_preferentialstatus_chronical_dmg",
		"de_10_a_75_ans_avec_dmg_a_partir_du_75eme_anniversaire_avec_sans_dmg_malade_chronique_avec_sans_dmg_medecin_stagiaire_avec_regime_preferentiel" to "trainee_regular_dmg_preferentialstatus,trainee_old_preferentialstatus,trainee_chronical_preferentialstatus",
		"de_10_a_75_ans_avec_dmg_a_partir_du_75eme_anniversaire_avec_sans_dmg_malade_chronique_avec_sans_dmg_medecin_stagiaire_sans_regime_preferentiel" to "trainee_regular_dmg_preferentialstatus,trainee_old_preferentialstatus,trainee_chronical_preferentialstatus",
		"avec_regime_preferentiel_a_taux_exceptionnel" to "preferentialstatus",
		"sans_regime_preferentiel_a_taux_exceptionnel" to "no_preferentialstatus",
		"avec_regime_preferentiel_enfant_avant_le_10eme_anniversaire_avec_ou_sans_dmg" to "child-120m_preferentialstatus",
		"enfant_avant_le_10eme_anniversaire_avec_ou_sans_dmg_avec_regime_preferentiel" to "child-120m_preferentialstatus",
		"sans_regime_preferentiel_enfant_avant_le_10eme_anniversaire_avec_ou_sans_dmg_a_partir_du_10eme_jusqu_a_son_75eme_anniversaire_avec_dmg_a_partir_du_75eme_anniversaire_sans_dmg_malade_chronique_sans_dmg" to "child-120m_no_preferentialstatus,regular_no_preferentialstatus_dmg,old_no_preferentialstatus_no_dmg,chronical_no_preferentialstatus_no_dmg",
		"sans_regime_preferentiel_enfant_avant_le_10eme_anniversaire_avec_sans_dmg_a_partir_du_10eme_jusqu_a_son_75eme_anniversaire_avec_dmg_a_partir_du_75eme_anniversaire_avec_sans_dmg_malade_chronique_avec_sans_dmg" to "child-120m_no_preferentialstatus,regular_no_preferentialstatus_dmg,old_no_preferentialstatus,chronical_no_preferentialstatus",
		"enfant_avant_le_10eme_anniversaire_avec_ou_sans_dmg_sans_regime_preferentiel" to "child-120m_no_preferentialstatus",
		"sans_regime_preferentiel_enfant_avant_le_10eme_anniversaire_avec_ou_sans_dmg" to "child-120m_no_preferentialstatus",
		"enfant_avant_le_10eme_anniversaire_avec_ou_sans_dmg_a_partir_du_10eme_jusqu_a_son_75eme_anniversaire_avec_dmg_a_partir_du_75eme_anniversaire_sans_dmg_malade_chronique_sans_dmg" to "child-120m,regular_dmg,old_no_dmg,chronical_no_dmg",
		"enfant_avant_le_10eme_anniversaire_avec_ou_sans_dmg_a_partir_du_10eme_jusqu_a_son_75eme_anniversaire_avec_dmg_a_partir_du_75eme_anniversaire_avec_ou_sans_dmg_malade_chronique_avec_ou_sans_dmg" to "child-120m,regular_dmg,old,chronical",
		"enfant_avant_le_10eme_anniversaire_avec_ou_sans_dossier_medical_global" to "child-120m",
		"jusqu_au_18eme_anniversaire_sans_regime_preferentiel" to "child-18y_no_preferentialstatus",
		"jusqu_au_18eme_anniversaire_avec_regime_preferentiel" to "child-18y_preferentialstatus",
		"jusqu_au_18eme_anniversaire" to "child-18y",
		"avec_regime_preferentiel_prestataire_conventionne_cabinet" to "preferentialstatus_convention",
		"avec_regime_preferentiel_prestataire_non_conventionne_cabinet" to "preferentialstatus_no_convention",
		"sans_regime_preferentiel_prestataire_conventionne_cabinet" to "no_preferentialstatus_convention",
		"sans_regime_preferentiel_prestataire_non_conventionne_cabinet" to "no_preferentialstatus_no_convention",
		"enfant_de_moins_de_5_ans_sans_regime_preferentiel" to "child-60m_no_preferentialstatus",
		"enfant_de_moins_de_5_ans" to "child-60m",
		"chez_les_nouveau_nes_et_les_nourrissons_de_moins_de_6_mois" to "child-6m",
		"enfant_de_moins_de_7_ans_sans_regime_preferentiel" to "child-84m_no_preferentialstatus",
		"enfant_de_moins_de_7_ans" to "child-84m",
		"_enfant_avant_le_10eme_anniversaire_avec_ou_sans_dossier_medical_global" to "child",
		"sans_regime_preferentiel_dans_le_cadre_du_dmg" to "dmg_no_preferentialstatus",
		"avec_regime_preferentiel_dans_le_cadre_du_dmg" to "dmg_preferentialstatus",
		"dans_le_cadre_du_dossier_medical_global" to "dmg",
		"a_partir_du_18eme_anniversaire_sans_regime_preferentiel" to "major_no_preferentialstatus",
		"a_partir_du_18eme_anniversaire_avec_regime_preferentiel" to "major_preferentialstatus",
		"a_partir_du_18eme_anniversaire" to "major",
		"chez_les_nouveau_nes_et_les_nourrissons_de_moins_de_6_mois_sans_regime_preferentiel" to "no_preferentialstatus_child-6m",
		"intervention_sans_regime_preferentiel_prestataire_conventionne_a_taux_exceptionnel" to "no_preferentialstatus_convention",
		"sans_regime_preferentiel_prestataire_conventionne_montant_arrondi_par_unite" to "no_preferentialstatus_convention",
		"sans_regime_preferentiel_prestataire_conventionne_montant_non_arrondi_par_unite" to "no_preferentialstatus_convention",
		"sans_regime_preferentiel_prestataire_conventionne" to "no_preferentialstatus_convention",
		"sans_regime_preferentiel_prestataire_non_conventionne_a_taux_exceptionel" to "no_preferentialstatus_no_convention",
		"sans_regime_preferentiel_prestataire_non_conventionne_montant_arrondi_par_unite" to "no_preferentialstatus_no_convention",
		"sans_regime_preferentiel_prestataire_non_conventionne" to "no_preferentialstatus_no_convention",
		"a_taux_exceptionnel_sans_regime_preferentiel" to "no_preferentialstatus",
		"patient_palliatif_sans_regime_preferentiel" to "no_preferentialstatus",
		"sans_regime_preferentiel_a_50_" to "no_preferentialstatus",
		"sans_regime_preferentiel_a_75_" to "no_preferentialstatus",
		"sans_regime_preferentiel_a_88_" to "no_preferentialstatus",
		"sans_regime_preferentiel_fonction_agreee_de_soins_intensifs" to "no_preferentialstatus",
		"sans_regime_preferentiel_pas_de_prestations_dans_l_annee_calendrier_precedente" to "no_preferentialstatus",
		"sans_regime_preferentiel_pour_anesthesie_pratiquee_au_cours_d_une_prestation_dont_la_valeur_relative_est_egale_ou_superieure_a_k_400_n_600_ou_i_600" to "no_preferentialstatus",
		"sans_regime_preferentiel_pour_anesthesie_pratiquee_au_cours_d_une_prestation_dont_la_valeur_relative_est_superieure_a_k_75_n_125_ou_i_125_et_inferieure_a_k_400_n_600_ou_i_600" to "no_preferentialstatus",
		"sans_regime_preferentiel_pour_prestation_dans_categorie_i_600" to "no_preferentialstatus",
		"sans_regime_preferentiel_pour_prestation_dans_categorie_k_180_ou_n_300_et_k_400_ou_n_600" to "no_preferentialstatus",
		"sans_regime_preferentiel_pour_prestation_dans_categorie_k_300_ou_n500_et_k_390_ou_n_600" to "no_preferentialstatus",
		"sans_regime_preferentiel_pour_prestation_dans_categorie_k_75_et_k_400" to "no_preferentialstatus",
		"sans_regime_preferentiel_pour_prestation_dans_categorie_k400_ou_n_600" to "no_preferentialstatus",
		"sans_regime_preferentiel_pour_prestation_dans_categorie_n_600_ou_i_600" to "no_preferentialstatus",
		"sans_regime_preferentiel_pour_prothese_amovible_de_1_a_5_dents" to "no_preferentialstatus",
		"sans_regime_preferentiel_pour_prothese_amovible_de_10_ou_11_dents" to "no_preferentialstatus",
		"sans_regime_preferentiel_pour_prothese_amovible_de_12_dents_et_plus" to "no_preferentialstatus",
		"sans_regime_preferentiel_prix_sur_facture" to "no_preferentialstatus",
		"sans_regime_preferentiel_si_les_conditions_ne_sont_pas_respectees" to "no_preferentialstatus",
		"sans_regime_preferentiel_sur_base_du_paragraphe_1_de_l_article_7" to "no_preferentialstatus",
		"sans_regime_preferentiel_sur_base_du_paragraphe_2_de_l_article_7" to "no_preferentialstatus",
		"sans_regime_preferentiel_sur_base_du_paragraphe_3_de_l_article_7" to "no_preferentialstatus",
		"sans_regime_preferentiel" to "no_preferentialstatus",
		"sans_regime_preferentiel_a_partir_du_75eme_anniversaire_avec_dmg_et_malade_chronique_avec_dmg" to "old_dmg_no_preferentialstatus,chronical_no_preferentialstatus_dmg",
		"_a_partir_du_75eme_anniversaire_avec_dmg_et_malade_chronique_avec_dmg" to "old_dmg,chronical_dmg",
		"a_partir_du_75eme_anniversaire_avec_dmg_et_malade_chronique_avec_dmg" to "old_dmg,chronical_dmg",
		"avec_regime_preferentiel_a_partir_du_75eme_anniversaire_avec_dmg_et_malade_chronique_avec_dmg" to "old_preferentialstatus_dmg,chronical_preferentialstatus_dmg",
		"avec_regime_preferentiel_enfant_avant_le_10eme_anniversaire_avec_ou_sans_dmg_a_partir_du_10eme_jusqu_a_son_75eme_anniversaire_avec_dmg_a_partir_du_75eme_anniversaire_sans_dmg_malade_chronique_sans_dmg" to "preferentialstatus_child-120m,preferentialstatus_regular_dmg,preferentialstatus_regular_dmg,preferentialstatus_old_no_dmg,preferentialstatus_chronical_no_dmg",
		"avec_regime_preferentiel_enfant_avant_le_10eme_anniversaire_avec_sans_dmg_a_partir_du_10eme_jusqu_a_son_75eme_anniversaire_avec_dmg_a_partir_du_75eme_anniversaire_avec_sans_dmg_malade_chronique_avec_sans_dmg" to "preferentialstatus_child-120m,preferentialstatus_regular_dmg,preferentialstatus_regular_dmg,preferentialstatus_old,preferentialstatus_chronical",
		"enfant_de_moins_de_5_ans_avec_regime_preferentiel" to "preferentialstatus_child-60m",
		"chez_les_nouveau_nes_et_les_nourrissons_de_moins_de_6_mois_avec_regime_preferentiel" to "preferentialstatus_child-6m",
		"enfant_de_moins_de_7_ans_avec_regime_preferentiel" to "preferentialstatus_child-84m",
		"avec_regime_preferentiel_prestataire_conventionne_a_taux_exceptionnel" to "preferentialstatus_convention",
		"avec_regime_preferentiel_prestataire_conventionne_montant_arrondi_par_unite" to "preferentialstatus_convention",
		"avec_regime_preferentiel_prestataire_conventionne_montant_non_arrondi_par_unite" to "preferentialstatus_convention",
		"avec_regime_preferentiel_prestataire_conventionne" to "preferentialstatus_convention",
		"avec_regime_preferentiel_prestataire_non_conventionne_a_taux_exceptionnel" to "preferentialstatus_no_convention",
		"avec_regime_preferentiel_prestataire_non_conventionne_montant_arrondi_par_unite" to "preferentialstatus_no_convention",
		"avec_regime_preferentiel_prestataire_non_conventionne_montant_non_arrondi_par_unite" to "preferentialstatus_no_convention",
		"avec_regime_preferentiel_prestataire_non_conventionne" to "preferentialstatus_no_convention",
		"base_de_remboursement_avec_regime_preferentiel_prestataire_non_conventionne" to "preferentialstatus_no_convention",
		"a_taux_exceptionnel_avec_regime_preferentiel" to "preferentialstatus",
		"avec_regime_preferentiel_a_30_" to "preferentialstatus",
		"avec_regime_preferentiel_a_50_" to "preferentialstatus",
		"avec_regime_preferentiel_a_75_" to "preferentialstatus",
		"avec_regime_preferentiel_a_90_" to "preferentialstatus",
		"sans_regime_preferentiel_des_qui_consultent_un_medecin_specialiste_apres_avoir_ete_envoyes_par_un_medecin_generale" to "no_preferentialstatus_sentbygp",
		"avec_regime_preferentiel_des_qui_consultent_un_medecin_specialiste_apres_avoir_ete_envoyes_par_un_medecin_generale" to "preferentialstatus_sentbygp",
		"avec_regime_preferentiel_fonction_agreee_de_soins_intensifs" to "preferentialstatus",
		"avec_regime_preferentiel_montant_fixe" to "preferentialstatus",
		"avec_regime_preferentiel_pas_de_prestations_dans_l_annee_calendrier_precedent" to "preferentialstatus",
		"avec_regime_preferentiel_pas_de_prestations_dans_l_annee_calendrier_precedente" to "preferentialstatus",
		"avec_regime_preferentiel_pour_anesthesie_pratiquee_au_cours_d_une_prestation_dont_la_valeur_relative_est_egale_ou_superieure_a_k_400_n_600_ou_i_600" to "preferentialstatus",
		"avec_regime_preferentiel_pour_anesthesie_pratiquee_au_cours_d_une_prestation_dont_la_valeur_relative_est_superieure_a_k_75_n_125_ou_i_125_et_inferieure_a_k_400_n_600_ou_i_600" to "preferentialstatus",
		"avec_regime_preferentiel_pour_prestation_dans_categorie_i_600" to "preferentialstatus",
		"avec_regime_preferentiel_pour_prestation_dans_categorie_k_180_ou_n_300_et_k_400_ou_n_600" to "preferentialstatus",
		"avec_regime_preferentiel_pour_prestation_dans_categorie_k_300_ou_n500_et_k_390_ou_n_600" to "preferentialstatus",
		"avec_regime_preferentiel_pour_prestation_dans_categorie_k_300_ou_n500_ou_i_600_et_k_270_n450_ou_i_550" to "preferentialstatus",
		"avec_regime_preferentiel_pour_prestation_dans_categorie_k_400" to "preferentialstatus",
		"avec_regime_preferentiel_pour_prestation_dans_categorie_k_75_et_k_400" to "preferentialstatus",
		"avec_regime_preferentiel_pour_prestation_dans_categorie_k400_ou_n_600" to "preferentialstatus",
		"avec_regime_preferentiel_pour_prestation_dans_categorie_n_600_ou_i_600" to "preferentialstatus",
		"avec_regime_preferentiel_pour_prothese_amovible_de_1_a_5_dents" to "preferentialstatus",
		"avec_regime_preferentiel_pour_prothese_amovible_de_10_ou_11_dents" to "preferentialstatus",
		"avec_regime_preferentiel_pour_prothese_amovible_de_12_dents_et_plus" to "preferentialstatus",
		"avec_regime_preferentiel_pour_prothese_amovible_de_6_ou_7_dents" to "preferentialstatus",
		"avec_regime_preferentiel_pour_prothese_amovible_de_8_ou_9_dents" to "preferentialstatus",
		"avec_regime_preferentiel_prix_sur_facture" to "preferentialstatus",
		"avec_regime_preferentiel_si_les_conditions_ne_sont_pas_respectees" to "preferentialstatus",
		"avec_regime_preferentiel_sur_base_de_l_alinea_1_de_l_article_7" to "preferentialstatus",
		"avec_regime_preferentiel_sur_base_de_l_alinea_2_de_l_article_7" to "preferentialstatus",
		"avec_regime_preferentiel_sur_base_de_l_alinea_3_de_l_article_7" to "preferentialstatus",
		"avec_regime_preferentiel_sur_base_du_paragraphe_1_de_l_article_7" to "preferentialstatus",
		"avec_regime_preferentiel_sur_base_du_paragraphe_2_de_l_article_7" to "preferentialstatus",
		"avec_regime_preferentiel_sur_base_du_paragraphe_3_de_l_article_7" to "preferentialstatus",
		"avec_regime_preferentiel" to "preferentialstatus",
		"maximale_avec_regime_preferentiel" to "preferentialstatus",
		"patient_palliatif_avec_regime_preferentiel" to "preferentialstatus",
		"sans_regime_preferentiel_a_partir_du_10eme_jusqu_a_son_75eme_anniversaire_avec_dmg_a_partir_du_75eme_anniversaire_avec_sans_dmg_malade_chronique_avec_sans_dmg" to "regular_dmg_no_preferentialstatus,old_no_preferentialstatus,chronical_no_preferentialstatus",
		"sans_regime_preferentiel_a_partir_du_10eme_jusqu_a_son_75eme_anniversaire_avec_dmg_a_partir_du_75eme_anniversaire_sans_dmg_malade_chronique_sans_dmg" to "regular_dmg_no_preferentialstatus,old_no_preferentialstatus_no_dmg,chronical_no_preferentialstatus_no_dmg",
		"_a_partir_du_10eme_jusqu_a_son_75eme_anniversaire_avec_dmg_a_partir_du_75eme_anniversaire_sans_dmg_malade_chronique_sans_dmg" to "regular_dmg,old_no_dmg,chronical_no_dmg",
		"a_partir_du_10eme_jusqu_a_son_75eme_anniversaire_avec_dmg_a_partir_du_75eme_anniversaire_sans_dmg_malade_chronique_sans_dmg" to "regular_dmg,old_no_dmg,chronical_no_dmg",
		"_a_partir_du_10eme_jusqu_a_son_75eme_anniversaire_avec_dmg_a_partir_du_75eme_anniversaire_avec_ou_sans_dmg_malade_chronique_avec_ou_sans_dmg" to "regular_dmg,old,chronical",
		"a_partir_du_10eme_jusqu_a_son_75eme_anniversaire_avec_dmg_a_partir_du_75eme_anniversaire_avec_ou_sans_dmg_malade_chronique_avec_ou_sans_dmg" to "regular_dmg,old,chronical",
		"de_10_a_75_ans_sans_dmg_et_sans_etre_malade_chronique_sans_regime_preferentiel" to "regular_no_chronical_no_dmg_no_preferentialstatus",
		"a_partir_du_10eme_anniversaire_jusqu_a_son_75eme_anniversaire_sans_dmg_et_sans_etre_malade_chronique_avec_regime_preferentiel" to "regular_no_chronical_no_dmg_preferentialstatus",
		"a_partir_du_10eme_anniversaire_jusqu_a_son_75eme_anniversaire_sans_dmg_et_sans_etre_malade_chronique" to "regular_no_dmg_no_chronical",
		"sans_regime_preferentiel_a_partir_du_10eme_anniversaire_jusqu_a_son_75eme_anniversaire_sans_dmg_et_sans_etre_malade_chronique" to "regular_no_dmg_no_preferentialstatus_no_chronical",
		"_a_partir_du_10eme_anniversaire_jusqu_a_son_75eme_anniversaire_sans_dmg_et_sans_etre_malade_chronique" to "regular_no_dmg_no_preferentialstatus",
		"avec_regime_preferentiel_a_partir_du_10eme_jusqu_a_son_75eme_anniversaire_avec_dmg_a_partir_du_75eme_anniversaire_avec_sans_dmg_malade_chronique_avec_sans_dmg" to "regular_preferentialstatus_dmg,old_preferentialstatus,chronical_preferentialstatus",
		"avec_regime_preferentiel_a_partir_du_10eme_jusqu_a_son_75eme_anniversaire_avec_dmg_a_partir_du_75eme_anniversaire_sans_dmg_malade_chronique_sans_dmg" to "regular_preferentialstatus_dmg,old_preferentialstatus_no_dmg,chronical_preferentialstatus_no_dmg",
		"avec_regime_preferentiel_a_partir_du_10eme_anniversaire_jusqu_a_son_75eme_anniversaire_sans_dmg_et_sans_etre_malade_chronique" to "regular_preferentialstatus_no_dmg_no_chronical",
		"de_10_a_75_ans_avec_dmg_a_partir_du_75eme_anniversaire_sans_dmg_malade_chronique_sans_dmg_avec_regime_preferentiel" to "regular_preferentialstatus_dmg,old_no_dmg_preferentialstatus,chronical_no_dmg_preferentialstatus",
		"a_partir_du_75eme_anniversaire_avec_dmg_et_malade_chronique_avec_dmg_avec_regime_preferentiel" to "old_dmg_preferentialstatus,chronical_dmg_preferentialstatus",
		"de_10_a_75_ans_avec_dmg_a_partir_du_75eme_anniversaire_avec_sans_dmg_malade_chronique_avec_sans_dmg_avec_regime_preferentiel" to "regular_dmg_preferentialstatus,old_preferentialstatus,chronical_preferentialstatus",
		"de_10_a_75_ans_avec_dmg_a_partir_du_75eme_anniversaire_avec_sans_dmg_malade_chronique_avec_sans_dmg_sans_regime_preferentiel" to "regular_dmg_no_preferentialstatus,old_no_preferentialstatus,chronical_no_preferentialstatus",
		"de_10_a_75_ans_avec_dmg_a_partir_du_75eme_anniversaire_sans_dmg_malade_chronique_sans_dmg_sans_regime_preferentiel" to "regular_dmg_no_preferentialstatus,old_no_dmg_no_preferentialstatus,chronical_no_dmg_no_preferentialstatus",
		"enfant_avant_le_10eme_anniversaire_avec_ou_sans_dmg_medecin_stagiaire_avec_regime_preferentiel" to "trainee_child-120m_preferentialstatus",
		"de_10_a_75_ans_sans_dmg_et_sans_etre_malade_chronique_medecin_stagiaire_une_des_conditions_de_surveillance_de_stage_non_rempli_avec_regime_preferentiel" to "trainee_regular_no_dmg_preferentialstatus",
		"enfant_avant_le_10eme_anniversaire_avec_ou_sans_dmg_medecin_stagiaire_sans_regime_preferentiel" to "trainee_child-120m_no_preferentialstatus",
		"de_10_a_75_ans_sans_dmg_et_sans_etre_malade_chronique_medecin_stagiaire_une_des_conditions_de_surveillance_de_stage_non_rempli_sans_regime_preferentiel" to "trainee_regular_no_chronical_no_dmg_no_preferentialstatus",
		"sans_regime_preferentiel_enfant_avant_le_10eme_anniversaire_avec_sans_dmg_de_10_a_75_ans_avec_dmg_a_partir_du_75eme_anniversaire_sans_dmg_malade_chronique_sans_dmg_medecin_stagiaire" to "trainee_child-120m_no_preferentialstatus,trainee_regular_no_preferentialstatus_dmg,trainee_old_no_preferentialstatus_no_dmg,trainee_chronical_no_preferentialstatus_no_dmg",
		"sans_regime_preferentiel_enfant_avant_le_10eme_anniversaire_avec_sans_dmg_de_10_a_75_ans_avec_dmg_a_partir_du_75eme_anniversaire_avec_sans_dmg_malade_chronique_avec_sans_dmg_medecin_stagiaire" to "trainee_child-120m_no_preferentialstatus,trainee_regular_no_preferentialstatus_dmg,trainee_old_no_preferentialstatus,trainee_chronical_no_preferentialstatus",
		"medecin_stagiaire_enfant_avant_le_10eme_anniversaire_avec_sans_dmg_a_partir_du_10eme_jusqu_a_son_75eme_anniversaire_avec_dmg_a_partir_du_75eme_anniversaire_sans_dmg_malade_chronique_sans_dmg" to "trainee_child-120m,trainee_regular_dmg,trainee_old_no_dmg,trainee_chronical_no_dmg",
		"medecin_stagiaire_enfant_avant_le_10eme_anniversaire_avec_sans_dmg_a_partir_du_10eme_jusqu_a_son_75eme_anniversaire_avec_dmg_a_partir_du_75eme_anniversaire_avec_sans_dmg_malade_chronique_avec_sans_dmg" to "trainee_child-120m,trainee_regular_dmg,trainee_old,trainee_chronical",
		"medecin_stagiaire_enfant_avant_le_10eme_anniversaire_avec_ou_sans_dossier_medical_global" to "trainee_child-120m",
		"medecin_stagiaire_dans_le_cadre_du_dmg_1_des_conditions_surveillance_non_rempli" to "trainee_dmg",
		"sans_regime_preferentiel_enfant_avant_le_10eme_anniversaire_avec_ou_sans_dmg_medecin_stagiaire" to "trainee_no_preferentialstatus_child-120m",
		"sans_regime_preferentiel_dans_le_cadre_du_dmg_medecin_stagiaire_1_des_conditions_surveillance_non_rempli" to "trainee_no_preferentialstatus_dmg",
		"sans_regime_preferentiel_pas_dans_le_cadre_du_dmg_medecin_stagiaire_1_des_conditions_surveillance_non_rempli" to "trainee_no_preferentialstatus_no_dmg",
		"sans_regime_preferentiel_a_partir_du_75eme_anniversaire_avec_dmg_et_malade_chronique_avec_dmg_medecin_stagiaire_une_des_conditions_de_surveillance_de_stage_non_rempli" to "trainee_no_preferentialstatus_old_dmg_chronical_dmg",
		"sans_regime_preferentiel_de_10_a_75_ans_avec_dmg_a_partir_du_75eme_anniversaire_sans_dmg_malade_chronique_sans_dmg_medecin_stagiaire" to "trainee_no_preferentialstatus_regular,trainee_no_preferentialstatus_dmg_old,trainee_no_preferentialstatus_chronical_no_dmg",
		"sans_regime_preferentiel_de_10_a_75_ans_avec_dmg_a_partir_du_75eme_anniversaire_avec_sans_dmg_malade_chronique_avec_sans_dmg_medecin_stagiaire" to "trainee_no_preferentialstatus_regular_dmg,trainee_old_no_preferentialstatus,trainee_chronical_no_preferentialstatus",
		"sans_regime_preferentiel_a_partir_du_10eme_jusqu_a_son_75eme_anniversaire_sans_dmg_et_sans_etre_malade_chronique_medecin_stagiaire_une_des_conditions_de_surveillance_de_stage_non_rempli" to "trainee_no_preferentialstatus_regular_no_dmg_no_chronical",
		"sans_regime_preferentiel_des_qui_consultent_un_medecin_specialiste_apres_avoir_ete_envoyes_par_un_medecin_generale_medecin_specialiste_stagiaire" to "trainee_no_preferentialstatus",
		"sans_regime_preferentiel_medecin_specialiste_stagiaire" to "trainee_no_preferentialstatus",
		"medecin_stagiaire_a_partir_du_75eme_anniversaire_avec_dmg_et_malade_chronique_avec_dmg_une_des_conditions_de_surveillance_de_stage_non_rempli" to "trainee_old_dmg_chronical_dmg",
		"medecin_stagiaire_avec_regime_preferentiel_enfant_avant_le_10eme_anniversaire_avec_sans_dmg_de_10_a_75_ans_avec_dmg_a_partir_du_75eme_anniversaire_avec_sans_dmg_malade_chronique_avec_sans_dmg" to "trainee_preferentialstatus_child-120m,trainee_regular_preferentialstatus_dmg,trainee_old_preferentialstatus,trainee_chronical_preferentialstatus",
		"avec_regime_preferentiel_enfant_avant_le_10eme_anniversaire_avec_sans_dmg_de_10_a_75_ans_avec_dmg_a_partir_du_75eme_anniversaire_sans_dmg_malade_chronique_sans_dmg_medecin_stagiaire" to "trainee_preferentialstatus_child-120m,trainee_preferentialstatus_regular_dmg,trainee_preferentialstatus_old_no_dmg,trainee_preferentialstatus_chronical_no_dmg",
		"avec_regime_preferentiel_enfant_avant_le_10eme_anniversaire_avec_sans_dmg_de_10_a_75_ans_avec_dmg_a_partir_du_75eme_anniversaire_avec_sans_dmg_malade_chronique_avec_sans_dmg_medecin_stagiaire" to "trainee_preferentialstatus_child-120m,trainee_preferentialstatus_regular_dmg,trainee_preferentialstatus_old,trainee_preferentialstatus_chronical",
		"avec_regime_preferentiel_enfant_avant_le_10eme_anniversaire_avec_ou_sans_dmg_medecin_stagiaire" to "trainee_preferentialstatus_child-120m",
		"avec_regime_preferentiel_dans_le_cadre_du_dmg_medecin_stagiaire_1_des_conditions_surveillance_non_rempli" to "trainee_preferentialstatus_dmg",
		"avec_regime_preferentiel_pas_dans_le_cadre_du_dmg_medecin_stagiaire_1_des_conditions_surveillance_non_rempli" to "trainee_preferentialstatus_no_dmg",
		"avec_regime_preferentiel_a_partir_du_75eme_anniversaire_avec_dmg_et_malade_chronique_avec_dmg_medecin_stagiaire_une_des_conditions_de_surveillance_de_stage_non_rempli" to "trainee_preferentialstatus_old_dmg_chronical_dmg",
		"avec_regime_preferentiel_de_10_a_75_ans_avec_dmg_a_partir_du_75eme_anniversaire_avec_sans_dmg_malade_chronique_avec_sans_dmg_medecin_stagiaire" to "trainee_preferentialstatus_regular_dmg,trainee_old_preferentialstatus,trainee_chronical_preferentialstatus",
		"avec_regime_preferentiel_a_partir_du_10eme_jusqu_a_son_75eme_anniversaire_sans_dmg_et_sans_etre_malade_chronique_medecin_stagiaire_une_des_conditions_de_surveillance_de_stage_non_rempli" to "trainee_preferentialstatus_regular_no_dmg_no_chronical",
		"avec_regime_preferentiel_des_qui_consultent_un_medecin_specialiste_apres_avoir_ete_envoyes_par_un_medecin_generale_medecin_specialiste_stagiaire" to "trainee_preferentialstatus",
		"avec_regime_preferentiel_medecin_specialiste_stagiaire" to "trainee_preferentialstatus",
		"medecin_stagiaire_patient_palliatif_avec_regime_preferentiel_une_des_conditions_de_surveillance_de_stage_non_rempli" to "trainee_preferentialstatus",
		"medecin_stagiaire_patient_palliatif_sans_regime_preferentiel_une_des_conditions_de_surveillance_de_stage_non_rempli" to "trainee_preferentialstatus",
		"medecin_stagiaire_une_des_conditions_de_surveillande_de_stage_non_rempli_patient_palliatif_avec_regime_preferentiel" to "trainee_preferentialstatus",
		"avec_regime_preferentiel_de_10_a_75_ans_avec_dmg_a_partir_du_75eme_anniversaire_sans_dmg_malade_chronique_sans_dmg_medecin_stagiaire" to "trainee_regular_dmg,trainee_old_no_dmg,trainee_chronical_no_dmg",
		"medecin_stagiaire_a_partir_du_10eme_jusqu_a_son_75eme_anniversaire_avec_dmg_a_partir_du_75eme_anniversaire_sans_dmg_malade_chronique_sans_dmg" to "trainee_regular_dmg,trainee_old_no_dmg,trainee_chronical_no_dmg",
		"medecin_stagiaire_a_partir_du_10eme_jusqu_a_son_75eme_anniversaire_avec_dmg_a_partir_du_75eme_anniversaire_avec_sans_dmg_malade_chronique_avec_sans_dmg" to "trainee_regular_dmg,trainee_old,trainee_chronical",
		"medecin_stagiaire_a_partir_du_10eme_jusqu_a_son_75eme_anniversaire_sans_dmg_et_sans_etre_malade_chronique_une_des_conditions_de_surveillance_de_stage_non_rempli" to "trainee_regular_no_dmg_no_chronical",
		"medecin_specialiste_stagiaire" to "trainee",
		"medecin_stagiaire_1_des_conditions_surveillance_non_rempli" to "trainee",
		"medecin_stagiaire" to "trainee",
		"pour_les_qui_satisfont_aux_conditions_citees_dans_l_ar_du_16_02_2009_il_n_y_a_pas_d_personnelle_medecin_stagiaire_1_des_conditions_surveillance_non_rempli" to "trainee",
		"enfant_avant_le_10eme_anniversaire_avec_ou_sans_dmg_de_10_a_75_ans_avec_dmg_a_partir_du_75eme_anniversaire_sans_dmg_malade_chronique_sans_dmg_sans_regime_preferentiel" to "no_preferentialstatus_child-120m,no_preferentialstatus_regular_dmg,no_preferentialstatus_old_no_dmg,no_preferentialstatus_chronical_no_dmg",
		"sans_regime_preferentiel_enfant_avant_le_10eme_anniversaire_avec_sans_dmg_a_partir_du_10eme_jusqu_a_son_75eme_anniversaire_avec_dmg_ou_a_partir_du_75eme_anniversaire_avec_sans_dmg_malade_chronique_avec_sans_dmg" to "no_preferentialstatus_child-120m,no_preferentialstatus_regular_dmg,no_preferentialstatus_old,no_preferentialstatus_chronical"
	)

	val refValues = refs.entries.fold(persistentMapOf<String, List<String>>()) { map, (key, value) ->
		(value.split(",").toSet() + value).fold(map) { map, part -> map.put(part, map[part]?.let { it + key } ?: persistentListOf(key)) }
	}

	private fun splitTextKey(key: String) =
		Regex("(no_)?(.+?)_").findAll("${key}_").fold(persistentMapOf("preferentialstatus" to "any", "trainee" to "any", "child" to "any", "major" to "any", "old" to "any", "regular" to "any", "dmg" to "any", "chronical" to "any", "convention" to "any", "sentbygp" to "any")) { map, mr ->
			val g2 = mr.groupValues[2]
			if (g2.startsWith("child-")) {
				map.put("child", g2.substring(6).let { if (it.endsWith("y")) "${it.substring(0, it.length - 1).toInt() * 12}m" else it })
			} else {
				map.put(g2, if (mr.groupValues[1].isNotEmpty()) "no" else "yes")
			}
		}

	val conditions: Map<String, String> = refValues.entries.fold(persistentMapOf<String, String>()) { map, (key, value) ->
		val cnd = if (key.contains(",")) key.split(",").joinToString(" || ") {
			map[it]?.let { cnd -> "( $cnd )" } ?: "<<$it>>"
		} else splitTextKey(key).let { split ->
			split.keys.sorted().map { k ->
				val v = split[k]!!
				val ref = if (k == "convention" || k == "trainee") "hcp" else "patient"
				when {
					v == "any" -> "true"
					(k == "old" && v == "yes") -> "$ref.age >= 75"
					(k == "old" && v == "no") -> "$ref.age < 75"
					(k == "major" && v == "yes") -> "$ref.age >= 18"
					(k == "major" && v == "no") -> "$ref.age < 18"
					(k == "regular" && v == "yes") -> "( $ref.age >= 10 && $ref.age < 75 )"
					(k == "regular" && v == "no") -> "( $ref.age < 10 || $ref.age >= 75 )"
					(k == "child" && v == "no") -> "$ref.age >= 10"
					(k == "child") -> "$ref.age < ${v.replace("yes", "10").replace(Regex("([0-9]+)m"), "$1/12")}"
					v == "yes" -> "$ref.$k"
					v == "no" -> "!$ref.$k"
					else -> "$ref.$k == '$v'"
				}
			}.filter { it != "true" }.joinToString(" && ")
		}
		map.put(key, cnd.takeIf { it.isNotEmpty() } ?: "true")
	}.let { map ->
		map.entries.fold(map) { map, (key, value) ->
			if (value.contains("<<")) {
				map.put(key, value.replace(Regex("<<(.+)>>")) { "( ${map[it.groupValues[1]]} )" })
			} else map
		}
	}
}

// GET /api/drug/{id}
export interface Drug {
    id: number;

    /**
     * Is this a first-line medication?
     */
    first_line: boolean;

    /**
     * INP name (universal name)
     */
    inp_name: string;

    trade_names: TradeName[];
    pharm_dynamics: string;
    pharm_kinetics: PharmKinetic[];

    side_effects: SideEffect[];

    contraindications: string;
    role_in_treatment: string;

    dosages: Dosage[];
    interactions: Interaction[];

    pregnancy_info: PregnancyInfo;
    liverDosageInfo: LiverDosageInfo;
    foodInfo: FoodInfo;
}

export interface TradeName {
    id: number;
    trade_name: string;
    pharm_form: string;
}

export interface PharmKinetic {
    id: number;
    name: string;
    value: string;
}

export interface SideEffect {
    id: number;
    effects: Effect['id'][];
    system: System['id'];
}

export interface Effect {
    id: number;
    effect: string;
}

export interface System {
    id: number;
    system: string;
}

export interface Dosage {
    id: number;
    adult: boolean;
    pharm_form: string;
    daily_dose: string;
    max_daily_dose: string;
}

export interface ActingSubstance {
    id: number;
    name: string;
}

export interface Interaction {
    id: number;
    /**
     * The substance the interaction is with (2nd column)
     */
    acting_substance: ActingSubstance['id']
    kind_of_interaction: string;
    clinical_consequence: string;
}

export interface PregnancyInfo {
    fda_category: string;
    usage: string;
    additional_info: string;
}

export interface LiverDosageInfo {
    dose_change_prerequisites: string;
    creatinine_based_dosages: {
        creatinine_clearance: string;
        dosage_fraction: string;
    }[];
}

export interface FoodInfo {
    recommendations: string;
    comment: string;
}

// GET /api/drugs?skip={15}&take={pageSize}
export interface Page<T> {
    total: number;
    data: T[];
}

// Поиск (фильтрация)
// GET /api/drug/brief?search={searchString}
// GET /api/acting_substance/brief?search={searchString}
// returns Brief[]
export interface Brief {
    id: number;
    name: string;
}

// GET /api/drug/{drug.id}/interaction/{substance.id}
// type response = Interaction;

// Список препаратов, поиск препаратов, поиск веществ, просмотр одного препарата,
// Проверка совместимости

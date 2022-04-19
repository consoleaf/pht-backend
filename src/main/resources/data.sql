-- DELETE FROM public.interactions WHERE TRUE;
-- DELETE FROM public.acting_substances WHERE TRUE;
-- DELETE FROM public.creatinine_dosages WHERE TRUE;
-- DELETE FROM public.dosages WHERE TRUE;
-- DELETE FROM public.pharm_kinetic WHERE TRUE;
-- DELETE FROM public.trade_names WHERE TRUE;
-- DELETE FROM public.drugs WHERE TRUE;
--
-- ALTER SEQUENCE public.interactions_id_seq RESTART WITH 1;
-- ALTER SEQUENCE public.acting_substances_id_seq RESTART WITH 1;
-- ALTER SEQUENCE public.creatinine_dosages_id_seq RESTART WITH 1;
-- ALTER SEQUENCE public.dosages_id_seq RESTART WITH 1;
-- ALTER SEQUENCE public.pharm_kinetic_id_seq RESTART WITH 1;
-- ALTER SEQUENCE public.trade_names_id_seq RESTART WITH 1;
-- ALTER SEQUENCE public.drugs_id_seq RESTART WITH 1;

INSERT INTO public.acting_substances (name) VALUES ('Изониазид');
INSERT INTO public.acting_substances (name) VALUES ('Ацетилсалициловая кислота');
INSERT INTO public.acting_substances (name) VALUES ('TEST');
INSERT INTO public.acting_substances (name) VALUES ('Парацетамол');
INSERT INTO public.acting_substances (name) VALUES ('Опиоиды (морфин, фентанил, кодеин)');
INSERT INTO public.acting_substances (name) VALUES ('Теофиллин');
INSERT INTO public.acting_substances (name) VALUES ('Пиразинамид');
INSERT INTO public.acting_substances (name) VALUES ('Рифампицин');
INSERT INTO public.acting_substances (name) VALUES ('Этамбутол');
INSERT INTO public.acting_substances (name) VALUES ('Пробенецид');
INSERT INTO public.drugs (contraindications, dose_change_prerequisites, fda_category, first_line, food_comment, food_recommendations, inp_name, pharm_dynamics, pregnancy_additional_info, pregnancy_usage, role_in_treatment) VALUES ('Индивидуальная непереносимость препарата.
Эпилепсия.
Тяжелые психозы.
Склонность к судорожным припадкам.
Полиомиелит в анамнезе.
Токсический гепатит в анамнезе вследствие приема препаратов ГИНК.
Острая печеночная и почечная недостаточность.
', 'Противопоказано при тяжелой степени тяжести, при средней и легкой степени тяжести  - строгий мониторинг «печеночных» ферментов и использование гепатопротекторов', 'C', true, 'Запивать большим количеством воды.
Во время лечения следует избегать употребления сыра (особенно швейцарского или чеширского), рыбы (особенно тунца, сардинеллы, скипджека), поскольку при одновременном употреблении их с изониазидом возможно возникновение реакций (гиперемия кожи, зуд, ощущение жара или холода, сердцебиение, повышенное потоотделение, озноб, головная боль, головокружение), связанных с подавлением активности моноаминооксидазы (МАО) и диаминоксидазы и приводящих к нарушению метаболизма тирамина и гистамина, содержащихся в рыбе и сыре.
Этанол повышает гепатотоксичность изониазида и ускоряет его метаболизм', 'Внутрь, натощак (за 0,5 часа до еды или через 2 часа после еды).', 'Изониазид', 'Изониазид является пролекарством и активизируется микобактериальной каталазой. Механизм действия связан с угнетением синтеза миколевой кислоты в клеточной стенке M.tuberculosis. Изониазид оказывает бактерицидное действие на микобактерии в стадии размножения и бактериостатическое - в стадии покоя. При монотерапии изониазидом к нему быстро (в 70% случаев) развивается устойчивость.', 'Всегда вводится с 25-50 мг/сутки пиридоксина для снижения нейротоксичности у матери;
Начиная с 36 недель рекомендуется применение беременной витамина К 10 мг/ сутки per os и введение его новорожденному сразу после рождения для снижения риска послеродового кровотечения и геморрагического синдрома у новорожденного.
При проведении терапии определение трансаминаз ежемесячно', 'Следует применять только в тех случаях, когда предполагаемая польза для матери превышает потенциальный риск для плода в дозе не более 10 мг/кг.', 'Лечение и профилактика туберкулеза различной локализации у взрослых и детей.
Длительность приема не ограничена.
');
INSERT INTO public.drugs (contraindications, dose_change_prerequisites, fda_category, first_line, food_comment, food_recommendations, inp_name, pharm_dynamics, pregnancy_additional_info, pregnancy_usage, role_in_treatment) VALUES ('Гиперчувствительность ко всем компонентам, входящим в состав препарата; заболевания печени; подагра; гиперурикемия; грудное вскармливание; детский возраст до 3-x лет.
С осторожностью: сахарный диабет.', 'Не применяется', 'С', true, 'Запивать небольшим количеством воды.', 'Внутрь, во время или после еды, один раз в день.', 'Пиразинамид', 'Пиразинамид действует на внутриклеточно расположенные Mycobacterium tuberculosis. В зависимости от концентрации и чувствительности может оказывать бактериостатическое или бактерицидное действие. По туберкулостатической активности более активен, чем аминосалициловая кислота, хотя уступает изониазиду, стрептомицину, рифампицину. Пиразинамид хорошо проникает в очаги туберкулезного поражения. Его антибактериальная активность не снижается в кислой среде казеозных масс, в связи с чем его часто назначают при казеозном лимфадените, туберкуломе и казеозно-пневмонических процессах. В ходе лечения возможно развитие резистентности, вероятность развития которой снижает комбинирование с другими противотуберкулезными препаратами.', 'Возможно применение при резистентных формах туберкулёза и у ВИЧ инфицированных беременных.
', 'Данные на беременных очень малочисленны. Использование при беременности рекомендуется в случаях активного процесса', ' начиная со II триместра');
INSERT INTO public.creatinine_dosages (creatinine_clearance, dosage_fraction, drug_id) VALUES ('>50 мл/мин', '100% каждые 24 ч', 1);
INSERT INTO public.creatinine_dosages (creatinine_clearance, dosage_fraction, drug_id) VALUES ('30-50 мл/мин', '100% каждые 24 ч', 1);
INSERT INTO public.creatinine_dosages (creatinine_clearance, dosage_fraction, drug_id) VALUES ('10-30 мл/мин', '50% каждые 24 ч', 1);
INSERT INTO public.creatinine_dosages (creatinine_clearance, dosage_fraction, drug_id) VALUES ('<10 мл/мин', '50% каждые 24 ч', 1);
INSERT INTO public.creatinine_dosages (creatinine_clearance, dosage_fraction, drug_id) VALUES ('>50 мл/мин', 'Суточная доза 100% в 1-3 приема', 2);
INSERT INTO public.creatinine_dosages (creatinine_clearance, dosage_fraction, drug_id) VALUES ('30-50 мл/мин', 'Суточная доза 100% в 1-3 приема', 2);
INSERT INTO public.creatinine_dosages (creatinine_clearance, dosage_fraction, drug_id) VALUES ('10-30 мл/мин', 'Суточная доза 100% в 1-3 приема', 2);
INSERT INTO public.creatinine_dosages (creatinine_clearance, dosage_fraction, drug_id) VALUES ('<10 мл/мин', 'Суточная доза 100% в 1-3 приема', 2);
INSERT INTO public.dosages (adult, daily_dose, max_daily_dose, pharm_form, drug_id) VALUES (true, '4-6 мг/кг', '600 мг', 'Табл. 0,1г; 0,2г; 0,3г.', 1);
INSERT INTO public.dosages (adult, daily_dose, max_daily_dose, pharm_form, drug_id) VALUES (true, '10-15мг/кг', '200-300 мг', 'Раствор для инъекций, 100 мг/мл, по 5 мл.', 1);
INSERT INTO public.dosages (adult, daily_dose, max_daily_dose, pharm_form, drug_id) VALUES (true, '5-10 мг/кг (ингаляционно)
10-15 мг/кг (эндотрахеально)', '200-300 мг', 'Раствор для ингаляционного и эндотрахеального введения 100 мг/мл, по 5 мл.', 1);
INSERT INTO public.dosages (adult, daily_dose, max_daily_dose, pharm_form, drug_id) VALUES (false, '10-20мг/кг,
 для новорожденных 3-5 мг/кг', '100-300мг', 'Раствор для инъекций, 100 мг/мл, по 5 мл.', 1);
INSERT INTO public.dosages (adult, daily_dose, max_daily_dose, pharm_form, drug_id) VALUES (false, 'старше 3-х лет 7-15 мг/кг', '600 мг', 'Табл. 0,1г; 0,2г; 0,3г.', 1);
INSERT INTO public.dosages (adult, daily_dose, max_daily_dose, pharm_form, drug_id) VALUES (false, '5-10 мг/кг (ингаляционно)
10-15 мг/кг (эндотрахеально)', '200-300 мг', 'Раствор для ингаляционного и эндотрахеального введения 100 мг/мл, по 5 мл.', 1);
INSERT INTO public.dosages (adult, daily_dose, max_daily_dose, pharm_form, drug_id) VALUES (true, '25-30 мг/кг', '2500мг', 'Таблетки 500 мг', 2);
INSERT INTO public.dosages (adult, daily_dose, max_daily_dose, pharm_form, drug_id) VALUES (false, 'старше 3-х лет 15-20 мг/кг', '1500мг', 'Таблетки 500 мг', 2);
INSERT INTO public.interactions (clinical_consequence, kind_of_interaction, acting_substance_id, drug_id) VALUES ('Совместное применение не рекомендуется', 'Возможно ослабление эффекта изониазида', 2, 1);
INSERT INTO public.interactions (clinical_consequence, kind_of_interaction, acting_substance_id, drug_id) VALUES ('Совместное применение не рекомендуется, необходим мониторинг функции печени', 'Изониазид усиливает гепатотоксичность парацетамола', 4, 1);
INSERT INTO public.interactions (clinical_consequence, kind_of_interaction, acting_substance_id, drug_id) VALUES ('Необходим мониторинг побочных эффектов, при необходимости коррекция дозы опиоидов', 'Изониазид замедляет метаболизм опиоидов', 5, 1);
INSERT INTO public.interactions (clinical_consequence, kind_of_interaction, acting_substance_id, drug_id) VALUES ('Контроль концентрации теофиллина в сыворотке крови, в частности после прекращения применения изониазида, коррекция дозы теофиллина.', 'Изониазид замедляет метаболизм теофиллина', 6, 1);
INSERT INTO public.interactions (clinical_consequence, kind_of_interaction, acting_substance_id, drug_id) VALUES ('Следует уделять повышенное внимание побочным эффектам со стороны ЦНС, при необходимости коррекция дозы циклосерина/теризидона', 'Усиление токсичности в отношении ЦНС циклосерина/теризидона', 7, 1);
INSERT INTO public.interactions (clinical_consequence, kind_of_interaction, acting_substance_id, drug_id) VALUES ('Мониторинг функции печени', 'Усиление гепатотоксичности изониазида и пиразинамида', 7, 1);
INSERT INTO public.interactions (clinical_consequence, kind_of_interaction, acting_substance_id, drug_id) VALUES ('Совместное применение рекомендуется', 'Усиление лечебного эффекта', 8, 2);
INSERT INTO public.interactions (clinical_consequence, kind_of_interaction, acting_substance_id, drug_id) VALUES ('Совместное применение рекомендуется', 'Улучшение переносимости', 9, 2);
INSERT INTO public.interactions (clinical_consequence, kind_of_interaction, acting_substance_id, drug_id) VALUES ('Усиление токсических реакций пиразинамида', 'Снижение экскреции пиразинамида', 10, 2);
INSERT INTO public.pharm_kinetic (name, value, drug_id) VALUES ('Адсорбция из ЖКТ', 'Быстрая и полная', 1);
INSERT INTO public.pharm_kinetic (name, value, drug_id) VALUES ('Биодоступность, %', 'Выводится в основном почками', 1);
INSERT INTO public.pharm_kinetic (name, value, drug_id) VALUES ('Связь с белками плазмы крови, %', 'Быстрая и полная', 1);
INSERT INTO public.pharm_kinetic (name, value, drug_id) VALUES ('Биотрансформация', 'Выводится в основном почками', 1);
INSERT INTO public.pharm_kinetic (name, value, drug_id) VALUES ('Проникновение через ГЭБ', 'Быстрая и полная', 1);
INSERT INTO public.pharm_kinetic (name, value, drug_id) VALUES ('Т1/2,ч', 'Выводится в основном почками', 1);
INSERT INTO public.pharm_kinetic (name, value, drug_id) VALUES ('Экскреция', 'Биотрансформация', 1);
INSERT INTO public.pharm_kinetic (name, value, drug_id) VALUES ('Адсорбция из ЖКТ', 'хорошая', 2);
INSERT INTO public.pharm_kinetic (name, value, drug_id) VALUES ('Связь с белками плазмы крови, %', '10-20', 2);
INSERT INTO public.pharm_kinetic (name, value, drug_id) VALUES ('Биотрансформация', 'Метаболизируется в печени с образованием активного метаболита пиразиновой кислоты, которая в дальнейшем превращается в неактивный метаболит – 5-гидроксипиразиноевую кислоту', 2);
INSERT INTO public.pharm_kinetic (name, value, drug_id) VALUES ('Проникновение через ГЭБ', 'хорошее', 2);
INSERT INTO public.pharm_kinetic (name, value, drug_id) VALUES ('Т1/2,ч', '9-10', 2);
INSERT INTO public.pharm_kinetic (name, value, drug_id) VALUES ('Экскреция', 'Выводится в основном почками (3% – в неизмененном виде, 33% – в виде пиразиновой кислоты и 36 % – в виде других метаболитов).', 2);
INSERT INTO public.trade_names (pharm_form, trade_name, drug_id) VALUES ('таблетки', 'Изониазид-Эдвансд', 1);
INSERT INTO public.trade_names (pharm_form, trade_name, drug_id) VALUES ('таблетки', 'Изониазид', 1);
INSERT INTO public.trade_names (pharm_form, trade_name, drug_id) VALUES ('раствор для инъекций', 'Изониазид', 1);
INSERT INTO public.trade_names (pharm_form, trade_name, drug_id) VALUES ('раствор для инъекций', 'Изониазид – Ферейн', 1);
INSERT INTO public.trade_names (pharm_form, trade_name, drug_id) VALUES ('раствор для внутривенного, внутримышечного, ингаляционного и эндотрахеального введения', 'Изониазид-Дарница', 1);
INSERT INTO public.trade_names (pharm_form, trade_name, drug_id) VALUES ('раствор для инъекций и ингаляций', 'Изониазид', 1);
INSERT INTO public.trade_names (pharm_form, trade_name, drug_id) VALUES ('таблетки, покрытые пленочной оболочкой', 'Пиразинамид', 2);
INSERT INTO public.trade_names (pharm_form, trade_name, drug_id) VALUES ('таблетки, покрытые пленочной оболочкой', 'Пиразинамид-Эдвансд', 2);
INSERT INTO public.trade_names (pharm_form, trade_name, drug_id) VALUES ('таблетки', 'Пиразинамид ', 2);
INSERT INTO public.trade_names (pharm_form, trade_name, drug_id) VALUES ('таблетки', 'МАКРОЗИД®', 2);
INSERT INTO public.trade_names (pharm_form, trade_name, drug_id) VALUES ('таблетки', 'Линамид ', 2);

SELECT TRUE;

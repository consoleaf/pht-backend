DELETE FROM public.interactions WHERE TRUE;
DELETE FROM public.acting_substances WHERE TRUE;
DELETE FROM public.creatinine_dosages WHERE TRUE;
DELETE FROM public.dosages WHERE TRUE;
DELETE FROM public.pharm_kinetic WHERE TRUE;
DELETE FROM public.trade_names WHERE TRUE;
DELETE FROM public.drugs WHERE TRUE;

INSERT INTO public.drugs (id, contraindications, dose_change_prerequisites, fda_category, first_line, food_comment, food_recommendations, inp_name, pharm_dynamics, pregnancy_additional_info, pregnancy_usage, role_in_treatment) VALUES (1, 'Индивидуальная непереносимость препарата.
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
INSERT INTO public.drugs (id, contraindications, dose_change_prerequisites, fda_category, first_line, food_comment, food_recommendations, inp_name, pharm_dynamics, pregnancy_additional_info, pregnancy_usage, role_in_treatment) VALUES (2, 'Гиперчувствительность ко всем компонентам, входящим в состав препарата; заболевания печени; подагра; гиперурикемия; грудное вскармливание; детский возраст до 3-x лет.
С осторожностью: сахарный диабет.', 'Не применяется', 'С', true, 'Запивать небольшим количеством воды.', 'Внутрь, во время или после еды, один раз в день.', 'Пиразинамид', 'Пиразинамид действует на внутриклеточно расположенные Mycobacterium tuberculosis. В зависимости от концентрации и чувствительности может оказывать бактериостатическое или бактерицидное действие. По туберкулостатической активности более активен, чем аминосалициловая кислота, хотя уступает изониазиду, стрептомицину, рифампицину. Пиразинамид хорошо проникает в очаги туберкулезного поражения. Его антибактериальная активность не снижается в кислой среде казеозных масс, в связи с чем его часто назначают при казеозном лимфадените, туберкуломе и казеозно-пневмонических процессах. В ходе лечения возможно развитие резистентности, вероятность развития которой снижает комбинирование с другими противотуберкулезными препаратами.', 'Возможно применение при резистентных формах туберкулёза и у ВИЧ инфицированных беременных.
', 'Данные на беременных очень малочисленны. Использование при беременности рекомендуется в случаях активного процесса', ' начиная со II триместра');
INSERT INTO public.acting_substances (id, name, drug_id) VALUES (1, 'Изониазид', 1);
INSERT INTO public.acting_substances (id, name, drug_id) VALUES (4, 'Парацетамол', null);
INSERT INTO public.acting_substances (id, name, drug_id) VALUES (5, 'Опиоиды (морфин, фентанил, кодеин)', null);
INSERT INTO public.acting_substances (id, name, drug_id) VALUES (6, 'Теофиллин', null);
INSERT INTO public.acting_substances (id, name, drug_id) VALUES (7, 'Пиразинамид', 2);
INSERT INTO public.acting_substances (id, name, drug_id) VALUES (8, 'Рифампицин', null);
INSERT INTO public.acting_substances (id, name, drug_id) VALUES (9, 'Этамбутол', null);
INSERT INTO public.acting_substances (id, name, drug_id) VALUES (10, 'Пробенецид', null);
INSERT INTO public.acting_substances (id, name, drug_id) VALUES (2, 'Ацетилсалициловая кислота', null);
INSERT INTO public.creatinine_dosages (id, creatinine_clearance, dosage_fraction, drug_id) VALUES (1, '>50 мл/мин', '100% каждые 24 ч', 1);
INSERT INTO public.creatinine_dosages (id, creatinine_clearance, dosage_fraction, drug_id) VALUES (2, '30-50 мл/мин', '100% каждые 24 ч', 1);
INSERT INTO public.creatinine_dosages (id, creatinine_clearance, dosage_fraction, drug_id) VALUES (3, '10-30 мл/мин', '50% каждые 24 ч', 1);
INSERT INTO public.creatinine_dosages (id, creatinine_clearance, dosage_fraction, drug_id) VALUES (4, '<10 мл/мин', '50% каждые 24 ч', 1);
INSERT INTO public.creatinine_dosages (id, creatinine_clearance, dosage_fraction, drug_id) VALUES (5, '>50 мл/мин', 'Суточная доза 100% в 1-3 приема', 2);
INSERT INTO public.creatinine_dosages (id, creatinine_clearance, dosage_fraction, drug_id) VALUES (6, '30-50 мл/мин', 'Суточная доза 100% в 1-3 приема', 2);
INSERT INTO public.creatinine_dosages (id, creatinine_clearance, dosage_fraction, drug_id) VALUES (7, '10-30 мл/мин', 'Суточная доза 100% в 1-3 приема', 2);
INSERT INTO public.creatinine_dosages (id, creatinine_clearance, dosage_fraction, drug_id) VALUES (8, '<10 мл/мин', 'Суточная доза 100% в 1-3 приема', 2);
INSERT INTO public.dosages (id, adult, daily_dose, max_daily_dose, pharm_form, drug_id) VALUES (1, true, '4-6 мг/кг', '600 мг', 'Табл. 0,1г; 0,2г; 0,3г.', 1);
INSERT INTO public.dosages (id, adult, daily_dose, max_daily_dose, pharm_form, drug_id) VALUES (2, true, '10-15мг/кг', '200-300 мг', 'Раствор для инъекций, 100 мг/мл, по 5 мл.', 1);
INSERT INTO public.dosages (id, adult, daily_dose, max_daily_dose, pharm_form, drug_id) VALUES (3, true, '5-10 мг/кг (ингаляционно)
10-15 мг/кг (эндотрахеально)', '200-300 мг', 'Раствор для ингаляционного и эндотрахеального введения 100 мг/мл, по 5 мл.', 1);
INSERT INTO public.dosages (id, adult, daily_dose, max_daily_dose, pharm_form, drug_id) VALUES (5, false, '10-20мг/кг,
 для новорожденных 3-5 мг/кг', '100-300мг', 'Раствор для инъекций, 100 мг/мл, по 5 мл.', 1);
INSERT INTO public.dosages (id, adult, daily_dose, max_daily_dose, pharm_form, drug_id) VALUES (4, false, 'старше 3-х лет 7-15 мг/кг', '600 мг', 'Табл. 0,1г; 0,2г; 0,3г.', 1);
INSERT INTO public.dosages (id, adult, daily_dose, max_daily_dose, pharm_form, drug_id) VALUES (6, false, '5-10 мг/кг (ингаляционно)
10-15 мг/кг (эндотрахеально)', '200-300 мг', 'Раствор для ингаляционного и эндотрахеального введения 100 мг/мл, по 5 мл.', 1);
INSERT INTO public.dosages (id, adult, daily_dose, max_daily_dose, pharm_form, drug_id) VALUES (7, true, '25-30 мг/кг', '2500мг', 'Таблетки 500 мг', 2);
INSERT INTO public.dosages (id, adult, daily_dose, max_daily_dose, pharm_form, drug_id) VALUES (8, false, 'старше 3-х лет 15-20 мг/кг', '1500мг', 'Таблетки 500 мг', 2);
INSERT INTO public.interactions (id, clinical_consequence, kind_of_interaction, acting_substance_id, drug_id) VALUES (1, 'Совместное применение не рекомендуется', 'Возможно ослабление эффекта изониазида', 2, 1);
INSERT INTO public.interactions (id, clinical_consequence, kind_of_interaction, acting_substance_id, drug_id) VALUES (6, 'Мониторинг функции печени', 'Усиление гепатотоксичности изониазида и пиразинамида', 7, 1);
INSERT INTO public.interactions (id, clinical_consequence, kind_of_interaction, acting_substance_id, drug_id) VALUES (7, 'Совместное применение рекомендуется', 'Усиление лечебного эффекта', 8, 2);
INSERT INTO public.interactions (id, clinical_consequence, kind_of_interaction, acting_substance_id, drug_id) VALUES (8, 'Совместное применение рекомендуется', 'Улучшение переносимости', 9, 2);
INSERT INTO public.interactions (id, clinical_consequence, kind_of_interaction, acting_substance_id, drug_id) VALUES (9, 'Усиление токсических реакций пиразинамида', 'Снижение экскреции пиразинамида', 10, 2);
INSERT INTO public.interactions (id, clinical_consequence, kind_of_interaction, acting_substance_id, drug_id) VALUES (4, 'Контроль концентрации теофиллина в сыворотке крови, в частности после прекращения применения изониазида, коррекция дозы теофиллина.', 'Изониазид замедляет метаболизм теофиллина', 6, 1);
INSERT INTO public.interactions (id, clinical_consequence, kind_of_interaction, acting_substance_id, drug_id) VALUES (5, 'Следует уделять повышенное внимание побочным эффектам со стороны ЦНС, при необходимости коррекция дозы циклосерина/теризидона', 'Усиление токсичности в отношении ЦНС циклосерина/теризидона', 7, 1);
INSERT INTO public.interactions (id, clinical_consequence, kind_of_interaction, acting_substance_id, drug_id) VALUES (3, 'Необходим мониторинг побочных эффектов, при необходимости коррекция дозы опиоидов', 'Изониазид замедляет метаболизм опиоидов', 5, 1);
INSERT INTO public.interactions (id, clinical_consequence, kind_of_interaction, acting_substance_id, drug_id) VALUES (2, 'Совместное применение не рекомендуется, необходим мониторинг функции печени', 'Изониазид усиливает гепатотоксичность парацетамола', 4, 1);
INSERT INTO public.pharm_kinetic (id, name, value, drug_id) VALUES (1, 'Адсорбция из ЖКТ', 'Быстрая и полная', 1);
INSERT INTO public.pharm_kinetic (id, name, value, drug_id) VALUES (2, 'Биодоступность, %', 'Выводится в основном почками', 1);
INSERT INTO public.pharm_kinetic (id, name, value, drug_id) VALUES (3, 'Связь с белками плазмы крови, %', 'Быстрая и полная', 1);
INSERT INTO public.pharm_kinetic (id, name, value, drug_id) VALUES (4, 'Биотрансформация', 'Выводится в основном почками', 1);
INSERT INTO public.pharm_kinetic (id, name, value, drug_id) VALUES (5, 'Проникновение через ГЭБ', 'Быстрая и полная', 1);
INSERT INTO public.pharm_kinetic (id, name, value, drug_id) VALUES (6, 'Т1/2,ч', 'Выводится в основном почками', 1);
INSERT INTO public.pharm_kinetic (id, name, value, drug_id) VALUES (7, 'Экскреция', 'Биотрансформация', 1);
INSERT INTO public.pharm_kinetic (id, name, value, drug_id) VALUES (8, 'Адсорбция из ЖКТ', 'хорошая', 2);
INSERT INTO public.pharm_kinetic (id, name, value, drug_id) VALUES (9, 'Связь с белками плазмы крови, %', '10-20', 2);
INSERT INTO public.pharm_kinetic (id, name, value, drug_id) VALUES (10, 'Биотрансформация', 'Метаболизируется в печени с образованием активного метаболита пиразиновой кислоты, которая в дальнейшем превращается в неактивный метаболит – 5-гидроксипиразиноевую кислоту', 2);
INSERT INTO public.pharm_kinetic (id, name, value, drug_id) VALUES (11, 'Проникновение через ГЭБ', 'хорошее', 2);
INSERT INTO public.pharm_kinetic (id, name, value, drug_id) VALUES (12, 'Т1/2,ч', '9-10', 2);
INSERT INTO public.pharm_kinetic (id, name, value, drug_id) VALUES (13, 'Экскреция', 'Выводится в основном почками (3% – в неизмененном виде, 33% – в виде пиразиновой кислоты и 36 % – в виде других метаболитов).', 2);
INSERT INTO public.trade_names (id, pharm_form, trade_name, drug_id) VALUES (1, 'таблетки', 'Изониазид-Эдвансд', 1);
INSERT INTO public.trade_names (id, pharm_form, trade_name, drug_id) VALUES (2, 'таблетки', 'Изониазид', 1);
INSERT INTO public.trade_names (id, pharm_form, trade_name, drug_id) VALUES (3, 'раствор для инъекций', 'Изониазид', 1);
INSERT INTO public.trade_names (id, pharm_form, trade_name, drug_id) VALUES (4, 'раствор для инъекций', 'Изониазид – Ферейн', 1);
INSERT INTO public.trade_names (id, pharm_form, trade_name, drug_id) VALUES (5, 'раствор для внутривенного, внутримышечного, ингаляционного и эндотрахеального введения', 'Изониазид-Дарница', 1);
INSERT INTO public.trade_names (id, pharm_form, trade_name, drug_id) VALUES (6, 'раствор для инъекций и ингаляций', 'Изониазид', 1);
INSERT INTO public.trade_names (id, pharm_form, trade_name, drug_id) VALUES (8, 'таблетки, покрытые пленочной оболочкой', 'Пиразинамид-Эдвансд', 2);
INSERT INTO public.trade_names (id, pharm_form, trade_name, drug_id) VALUES (7, 'таблетки, покрытые пленочной оболочкой', 'Пиразинамид', 2);
INSERT INTO public.trade_names (id, pharm_form, trade_name, drug_id) VALUES (11, 'таблетки', 'Линамид ', 2);
INSERT INTO public.trade_names (id, pharm_form, trade_name, drug_id) VALUES (9, 'таблетки', 'Пиразинамид ', 2);
INSERT INTO public.trade_names (id, pharm_form, trade_name, drug_id) VALUES (10, 'таблетки', 'МАКРОЗИД®', 2);

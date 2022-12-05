package org.example;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * Обработчик результатов соревнований.
 */
public interface ResultsProcessor {
    /**
     * Инициализирует список значениями из источника.
     * @param in источник
     */
    void loadRunners(Reader in) throws IOException;

    /**
     * Выбирает самых быстрых бегунов
     * @param N число вывбранных бегунов
     * @param distance расстояние
     * @param sex пол
     * @return список бегунов в соответствии с указанными параметрами
     */
    List<Runner> getFastestRunners(long N, int distance, String sex);

    /**
     * Возвращает истину, если содержимое списка в этом обработчике.
     * @param runnerList сравниваемый список, тип элемента {@link Runner}
     * @return истину, если есть все элеметы
     */
    boolean contains(List<Runner> runnerList);
}
